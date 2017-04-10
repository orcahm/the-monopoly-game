import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
/**
 * all operations is running in this class
 * @author Ahmet Oruc
 *
 */
public class Operation {

	private ArrayList<Location> propertyList;	//this is holding all map in itself
	private ArrayList<Integer> otherProperty;	// locations which is not in propery.json is holding in this
	private Player [] playerList;				
	private Banker banker;
	private WriteFile writeFile;				//this object is used for file writing operations 
	
	/**
	 * class constructer
	 * @param args arguments list
	 * @throws IOException is appearing when file is not found
	 * @throws ParseException .json files parsing operation error
	 */
	public Operation(String [] args) throws IOException, ParseException{
		
		writeFile = new WriteFile("output.txt");
		
		otherProperty = new ArrayList<Integer>();
		int [] tempPrperty = new int[] {1,3,5,8,11,18,21,23,31,34,37,39}; //locations which is not in property
		for(int i=0;i<tempPrperty.length;i++){
			otherProperty.add(tempPrperty[i]);
		}
		tempPrperty = null;
		
		ListJson listJson = new ListJson("list.json");
		PropertyJson propertyText = new PropertyJson("property.json");
		
		this.propertyList = new ArrayList<Location>();
		for(int i=0;i<41;i++){
			this.propertyList.add(null);
		}
		putProperty(propertyText);
		putProperty(listJson);
		
		playerList = new Player[2];
		playerList[0]=new Player("Player 1", 1,1);
		playerList[1]=new Player("Player 2", 1,2);
		banker= new Banker();
		
		ReadFile file = new ReadFile();
		file.read(args[0]);
		
		for(int i=0;i<file.line.size();i++){
			if(file.line.get(i).length()==0) continue;
			commandRun(file.line.get(i));
		}
		writeFile.show(playerList, banker,0);
		writeFile.close();
		
	}
	/**
	 * creating arraylist according to information in property file
	 * @param propertyText property file
	 */
	private void putProperty(PropertyJson propertyText){
		
		for(int i=0;i<propertyText.getId().size();i++){
			int index = propertyText.getId(i);
			
			if(i<=22){
				propertyList.set(index, new Street(propertyText.getId(i), propertyText.getName(i), propertyText.getCost(i)));
			}else if(i>22 && i<=26){
				propertyList.set(index, new Station(propertyText.getId(i), propertyText.getName(i), propertyText.getCost(i)));
			}else propertyList.set(index, new Company(propertyText.getId(i), propertyText.getName(i), propertyText.getCost(i)));
		}
	}
	/**
	 * infortmation which is read from list.json put their places
	 * @param list list file
	 */
	private void putProperty(ListJson list){
		
		LuckCard tempChance = new LuckCard(list.getChanceList(),"chance");
		LuckCard tempCommunity = new LuckCard(list.getCommunityChestList(),"community");
		
		for(int i=0;i<otherProperty.size();i++){
			if(otherProperty.get(i)==1 || otherProperty.get(i)==5 || otherProperty.get(i)==39){
				propertyList.set(otherProperty.get(i),new TaxAndGo(otherProperty.get(i)));
			}else if(otherProperty.get(i)==11 || otherProperty.get(i)==21){
				propertyList.set(otherProperty.get(i),new WaitPlace(otherProperty.get(i)));
			}else if(otherProperty.get(i)==31){
				propertyList.set(otherProperty.get(i),new GoToJail(otherProperty.get(i)));
			}else{
				if(otherProperty.get(i)==37 || otherProperty.get(i)==23 || otherProperty.get(i)==8){
					propertyList.set(otherProperty.get(i),tempChance);
				}else {
					propertyList.set(otherProperty.get(i),tempCommunity);
				}
				
			}
		}
	}
	/**
	 * all the commands is running line by line in here
	 * @param line commends.txt ''s one line
	 * @throws IOException for file not found exception
	 */
	private void commandRun(String line) throws IOException{
		
		String [] str1 = line.split(";");
		
		if(str1.length==2){
			String[] str2 = str1[0].split(" ");
			int player = Integer.parseInt(str2[1]);
			int dice = Integer.parseInt(str1[1]);
			int round =0;
			if(playerList[player-1].getWaitCount()==0) {
				round = playerList[player-1].goToProperyt(dice);
			}
			if(round==1){
				banker.changeMoney(-200);
			}
			int chancePlace = propertyList.get(playerList[player-1].getLocation()).run(playerList,banker,player,dice,writeFile,0);
			if(chancePlace==1){
				chancePlace = propertyList.get(playerList[player-1].getLocation()).run(playerList,banker,player,dice,writeFile,1);
			}
		}else{
			writeFile.show(playerList, banker,-1);
		}
		
	}
}
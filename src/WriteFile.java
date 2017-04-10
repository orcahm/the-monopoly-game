import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class for write to file
 * @author Ahmet Oruc
 *
 */
public class WriteFile {
	
	private FileWriter file;
	private BufferedWriter bf;
	
	public WriteFile(String fileName) throws IOException{
		file = new FileWriter(fileName); 
		bf = new BufferedWriter(file);
	}
	/**
	 * function for close file
	 * @throws IOException
	 */
	public void close() throws IOException{
		bf.close();
	}
	/**
	 * show command running in this function
	 * @param playerList
	 * @param banker
	 * @param winner
	 * @throws IOException
	 */
	public void show(Player [] playerList,Banker banker,int winner) throws IOException{
		
		StringBuilder strBuid = new StringBuilder();
		bf.append("-----------------------------------------------------------------------------------------------------------\n");
		for(int i=0;i<playerList.length;i++){
			strBuid.append(playerList[i].getName()+ "\t" + playerList[i].getMoney() + "\thave: ");
			for(int j=0;j<playerList[i].getOwnProperty().size();j++){
				if(j!=0) strBuid.append(",");
				strBuid.append(playerList[i].getOwnProperty().get(j).getName() );
			}
			strBuid.append("\n");
			bf.append(strBuid.toString());
			strBuid.delete(0, strBuid.length());
		}
		bf.append("Banker\t" + banker.getMoney() + "\n");
		if(winner==-1){
		if(playerList[0].getMoney()<playerList[1].getMoney()) winner = 1;
		else if(playerList[0].getMoney()>playerList[1].getMoney()) winner = 0;
		}
		if(winner ==-1){
			bf.append("Scoreless\n");
		}else bf.append("Winner\t" + playerList[winner].getName()+ "\n");
		bf.append("-----------------------------------------------------------------------------------------------------------\n");
	}
	/**
	 * function which is writing operations after throwing dice 
	 * @param player
	 * @param playerList
	 * @param dice
	 * @param command
	 * @throws IOException
	 */
	public void move(int player,Player [] playerList,int dice,String command) throws IOException{
		
		StringBuilder strBuil = new StringBuilder();
		strBuil.append(playerList[player-1].getName()+"\t"+
						dice + "\t" + playerList[player-1].getLocation() + "\t" +
						playerList[0].getMoney() + "\t" + playerList[1].getMoney()+ "\t"
						+ playerList[player-1].getName()+ " " + command + "\n");
		bf.append(strBuil.toString());
	}
	/**
	 * second operation in same move is doing in this function
	 * @param player
	 * @param playerList
	 * @param dice
	 * @param command
	 * @throws IOException
	 */
	public void moveOut(int player,Player [] playerList,int dice,String command) throws IOException{
		
		StringBuilder strBuil = new StringBuilder();
		strBuil.append(playerList[player-1].getName()+"\t"+
						dice + "\t" + playerList[player-1].getLocation() + "\t" +
						playerList[0].getMoney() + "\t" + playerList[1].getMoney()+ "\t"
						+ playerList[player-1].getName()+ " " + command +" ");
		bf.append(strBuil.toString());
	}
	
	public void write(String str) throws IOException{
		bf.append(str + "\n");
	}
}
	

import java.io.IOException;
import java.util.ArrayList;

/**
 * this class holding all player's properties
 * @author Ahmet Oruc
 *
 */
public class Player{

	private int playerId;
	private int location;
	private ArrayList<Location> ownProperty;
	private String name;
	private int money;
	private int ownerStationNumber;
	private int waitCount;
	
	public Player(){
		this.ownProperty = new ArrayList<Location>();
	}
	
	public Player(String name,int location,int id){
		this.name = name;
		this.money = 15000;
		this.playerId = id;
		this.location = location;
		this.ownerStationNumber=0;
		this.waitCount=0;
		this.ownProperty = new ArrayList<Location>();
	}
	
	/**
	 * make player move
	 * @param dice atılan zar
	 * @return
	 */
	public int goToProperyt(int dice){
		this.location += dice;
		if(this.location>40){
			this.location = (this.location%40);
			this.changeMoney(200);
			return 1;
		}
		return 0;
	}
	/**
	 * check if player is sink or not
	 * @param money
	 * @param playerList
	 * @param banker
	 * @param writeFile
	 * @param dice
	 * @param player
	 * @throws IOException
	 */
	public void moneyTransfer(int money,Player [] playerList,Banker banker,WriteFile writeFile,int dice,int player) throws IOException{
		if(this.money<money){
			writeFile.move(player, playerList, dice, "goes bankrupt");
			writeFile.show(playerList, banker,this.playerId%2);
			writeFile.close();
			System.exit(0);
		}
	}
	
	/**
	 * changes in player's money
	 * @param money
	 */
	public void changeMoney(int money){
		this.money += money;
	}
	/**
	 * command to buy location
	 * @param money
	 * @param property
	 */
	public void buy(int money,Location property){
		this.money -= money;
		this.ownProperty.add(property);
	}
	
	public void setLocation(int location){
		this.location = location;
	}
	
	public int getLocation() {
		return location;
	}

	public ArrayList<Location> getOwnProperty() {
		return ownProperty;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getPlayerId() {
		return playerId;
	}

	public int getOwnerStationNumber() {
		return ownerStationNumber;
	}

	public void setOwnerStationNumber(int ownerStationNumber) {
		this.ownerStationNumber += ownerStationNumber;
	}

	public int getWaitCount() {
		return waitCount;
	}

	public void setWaitCount(int waitCount) {
		this.waitCount = waitCount;
	}
}

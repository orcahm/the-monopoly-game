import java.io.IOException;
import java.util.Collections;

/**
 * stations are holding in this class
 * @author Ahmet Oruc
 *
 */
public class Station extends Property {

	public Station(int id,String name,int cost){
		super.setId(id);
		super.setName(name);
		super.setCost(cost);
		super.setOwner(0);
		super.setRent(25);
	}

	@Override
	public void rentCalculation() {
		this.setRent(25);
	}
	
	@Override
	public int run(Player[] playerList, Banker banker, int player,int dice,WriteFile writeFile,int count) throws IOException {
		if(super.getOwner()==0){
			playerList[player-1].moneyTransfer((int)super.getCost(), playerList, banker, writeFile,dice,player);
			super.setOwner(player);
			playerList[player-1].buy((int)this.getCost(), this);
			playerList[player-1].setOwnerStationNumber(1);
			banker.changeMoney((int)this.getCost());
			writeFile.move(player,playerList, dice, "bought " + this.getName());
		}else{
			if(this.getOwner() == player) {
				writeFile.move(player,playerList, dice, "has " + this.getName());
				return 0;
			}
			playerList[player-1].moneyTransfer((int)super.getCost(), playerList, banker, writeFile, dice , player);
			playerList[player-1].changeMoney(-this.getRent()*playerList[player-1].getOwnerStationNumber());
			playerList[super.getOwner()-1].changeMoney(-this.getRent()*playerList[player-1].getOwnerStationNumber());
			writeFile.move(player,playerList, dice, "paid rent for "  + this.getName());
		}
		return 0;
	}
}

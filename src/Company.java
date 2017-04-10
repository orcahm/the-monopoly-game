import java.io.IOException;
import java.util.Collections;

/**
 * class which is holding companies
 * @author Ahmet Oruc
 *
 */
public class Company extends Property{

	public Company(int id,String name,int cost){
		super.setId(id);
		super.setName(name);
		super.setCost(cost);
		super.setOwner(0);
	}

	@Override
	public void rentCalculation() {
		this.setRent(4);
	}

	@Override
	public int run(Player[] playerList, Banker banker, int player,int dice,WriteFile writeFile,int count) throws IOException {
		if(super.getOwner()==0){
			super.setOwner(player);
			playerList[player-1].moneyTransfer((int)super.getCost(), playerList, banker, writeFile, dice , player);
			playerList[player-1].buy((int)this.getCost(), this);
			banker.changeMoney((int)this.getCost());
			writeFile.move(player,playerList, dice, "bought " + this.getName());
		}else{
			if(this.getOwner() == player) {
				writeFile.move(player,playerList, dice, "has " + this.getName());
				return 0;
			}
			playerList[player-1].moneyTransfer((int)super.getCost(), playerList, banker, writeFile, dice , player);
			playerList[player-1].changeMoney(-this.getRent()*dice);
			playerList[super.getOwner()-1].changeMoney(this.getRent()*dice);
			writeFile.move(player,playerList, dice, "paid rent for "  + this.getName());
		}
		return 0;
	}

}

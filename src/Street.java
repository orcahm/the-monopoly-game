import java.io.IOException;

/**
 *All lands is holding in here
 * @author Ahmet Oruc
 *
 */
public class Street extends Property{

	public Street(int id,String name,int cost){
		super.setId(id);
		super.setName(name);
		super.setCost(cost);
		super.setOwner(0);
		this.rentCalculation();
	}

	@Override
	public int run(Player[] playerList, Banker banker, int player,int dice,WriteFile writeFile,int count) throws IOException {
		if(super.getOwner()==0){
			playerList[player-1].moneyTransfer((int)super.getCost(), playerList, banker, writeFile, dice , player);
			playerList[player-1].buy((int)this.getCost(), this);
			super.setOwner(player);
			banker.changeMoney((int)super.getCost());
			if(count==1){
				writeFile.write( "bought " + this.getName());
				return 0;
			}
			writeFile.move(player,playerList, dice, "bought " + this.getName());
		}else{
			if(this.getOwner() == player) {
				if(count==1){
					writeFile.write( "has " + this.getName());
					return 0;
				}
				writeFile.move(player,playerList, dice, "has " + this.getName());
				return 0;
			}
			playerList[player-1].moneyTransfer((int)super.getRent(), playerList, banker, writeFile, dice , player);
			playerList[player-1].changeMoney(-super.getRent());
			playerList[super.getOwner()-1].changeMoney(super.getRent());
			if(count==1){
				if(this.getName().equals("Leicester Square")){
					writeFile.moveOut(player, playerList, dice, "draw Advance to Leicester Square");
				}else writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
				writeFile.write("paid rent for " + this.getName());
				return 0;
			}
			writeFile.move(player,playerList, dice, "paid rent for " + this.getName());
		}
		return 0;
	}
	
	@Override
	public void rentCalculation() {
		if(super.getCost()>=0 && super.getCost()<=2000){
			super.setRent((int)((super.getCost()/100.0)*40));
		}else if(super.getCost()>=2001 && super.getCost()<=3000){
			super.setRent((int)((super.getCost()/100)*30));
		}else {
			super.setRent((int)((super.getCost()/100)*35));
		}
		
	}


}

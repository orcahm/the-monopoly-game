import java.io.IOException;
import java.util.ArrayList;

/**
 * chance and communitychest places holding in that class
 * @author Ahmet Oruc
 *
 */
public class LuckCard extends Location{
	
	private ArrayList<String> list=new ArrayList<String>();;
	private int index;
	private int cardNumber;

	public void LuckCard(ArrayList<String> list){
		super.setId(-1);
		this.list = new ArrayList<String>();
		this.list.addAll(list);
		this.index=0;
		cardNumber = list.size();
	}
	
	public LuckCard(ArrayList<String> list,String name){
		this.setName(name);
		this.LuckCard(list);
	}

	@Override
	public int run(Player[] playerList, Banker banker, int player,int dice,WriteFile writeFile,int count) throws IOException {
		String str = this.list.get(index);
		if(this.getName().equals("chance")){
			if(str.equals("Advance to Go (Collect $200)")){
				playerList[player-1].setLocation(1);
				playerList[player-1].changeMoney(200);
				banker.changeMoney(-200);
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("Advance to Leicester Square")){
				if(playerList[player-1].getLocation()>27){
					playerList[player-1].changeMoney(200);
					banker.changeMoney(-200);
				}
				playerList[player-1].setLocation(27);
				index += 1;
				index = index%cardNumber;
				return 1;
			}else if(str.equals("Go back 3 spaces")){
				playerList[player-1].goToProperyt(-3);
				index += 1;
				index = index%cardNumber;
				return 1;
			}else if(str.equals("Pay poor tax of $15")){
				playerList[player-1].moneyTransfer(15, playerList, banker, writeFile, dice, player);
				playerList[player-1].changeMoney(-15);
				banker.changeMoney(15);
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("Your building loan matures – collect $150")){
				playerList[player-1].changeMoney(150);
				banker.changeMoney(-150);
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("You have won a crossword competition - collect $100 ")){
				playerList[player-1].changeMoney(100);
				banker.changeMoney(-100);
				writeFile.move(player, playerList, dice, "draw " + str);
			}
		}else{
			if(str.equals("Advance to Go (Collect $200)")){
				playerList[player-1].setLocation(1);
				playerList[player-1].changeMoney(200);
				banker.changeMoney(-200);
				if(count==1){
					writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
					writeFile.write("paid Tax");
					return 0;
				}
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("Bank error in your favor – collect $75")){
				playerList[player-1].changeMoney(75);
				banker.changeMoney(-75);
				if(count==1){
					writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
					writeFile.write("paid Tax");
					return 0;
				}
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("Doctor's fees – Pay $50")){
				playerList[player-1].moneyTransfer(15, playerList, banker, writeFile, dice, player);
				playerList[player-1].changeMoney(-50);
				banker.changeMoney(50);
				if(count==1){
					writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
					writeFile.write("paid Tax");
					return 0;
				}
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("It is your birthday Collect $10 from each player")){
				playerList[player-1].changeMoney(10);
				playerList[player%2].moneyTransfer(15, playerList, banker, writeFile, dice, player);
				playerList[player%2].changeMoney(-10);
				if(count==1){
					writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
					writeFile.write("paid Tax");
					return 0;
				}
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("Grand Opera Night – collect $50 from every player for opening night seats")){
				playerList[player-1].changeMoney(50);
				playerList[player-1].moneyTransfer(15, playerList, banker, writeFile, dice, player);
				playerList[player%2].changeMoney(-50);
				if(count==1){
					writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
					writeFile.write("paid Tax");
					return 0;
				}
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("Income Tax refund – collect $20")){
				playerList[player-1].changeMoney(20);
				banker.changeMoney(-20);
				if(count==1){
					writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
					writeFile.write("paid Tax");
					return 0;
				}
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("Life Insurance Matures – collect $100")){
				playerList[player-1].changeMoney(100);
				banker.changeMoney(-100);
				if(count==1){
					writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
					writeFile.write("paid Tax");
					return 0;
				}
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("Pay Hospital Fees of $100")){
				playerList[player-1].changeMoney(-100);
				banker.changeMoney(100);
				if(count==1){
					writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
					writeFile.write("paid Tax");
					return 0;
				}
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("Pay School Fees of $50")){
				playerList[player-1].moneyTransfer(15, playerList, banker, writeFile, dice, player);
				playerList[player-1].changeMoney(-50);
				banker.changeMoney(50);
				if(count==1){
					writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
					writeFile.write("paid Tax");
					return 0;
				}
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("You inherit $100")){
				playerList[player-1].changeMoney(100);
				banker.changeMoney(-100);
				if(count==1){
					writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
					writeFile.write("paid Tax");
					return 0;
				}
				writeFile.move(player, playerList, dice, "draw " + str);
			}else if(str.equals("From sale of stock you get $50")){
				playerList[player-1].changeMoney(50);
				banker.changeMoney(-50);
				if(count==1){
					writeFile.moveOut(player, playerList, dice, "draw Go back 3 spaces");
					writeFile.write("paid Tax");
					return 0;
				}
				writeFile.move(player, playerList, dice, "draw " + str);
			}
			
		}
		index += 1;
		index = index%cardNumber;
		return 0;
	}
	
	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}


	
}

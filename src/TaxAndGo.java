import java.io.IOException;

/**
 * tax and go locations class
 * @author Ahmet Oruc
 *
 */
public class TaxAndGo extends Location{

	public TaxAndGo(int id){
		super.setId(id);
	}

	@Override
	public int run(Player[] playerList, Banker banker, int player,int dice,WriteFile writeFile,int count) throws IOException {
		if(playerList[player-1].getLocation()!=1){
			playerList[player-1].changeMoney(-100);
			banker.changeMoney(100);
			if(count==1){
				writeFile.write("paid Tax");
				return 0;
			}
			writeFile.move(player, playerList, dice, "paid Tax");
			return 0;
		}
		writeFile.move(player, playerList, dice, "is in GO square");
		return 0;
	}

	
}

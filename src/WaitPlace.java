import java.io.IOException;

/**
 * jail and freeparking  are hold here
 * @author Ahmet Oruc
 *
 */
public class WaitPlace extends Location{

	public WaitPlace(int id){
		super.setId(id);
	}

	@Override
	public int run(Player[] playerList, Banker banker, int player, int dice,WriteFile writeFile,int count) throws IOException {
		if(super.getId()==11){
			writeFile.move(player, playerList, dice, "in jail (count=" + playerList[player-1].getWaitCount() + ")");
			playerList[player-1].setWaitCount((playerList[player-1].getWaitCount()+1)%4);
		}else{
			writeFile.move(player, playerList, dice, "is in Free Parking");
		}
		return 0;
	}
	
}

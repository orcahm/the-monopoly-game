import java.io.IOException;

/**
 * Go to Jail location is holding in here
 * @author Ahmet Oruc
 *
 */
public class GoToJail extends Location{

	public GoToJail(int id){
		super.setId(id);
	}

	@Override
	public int run(Player[] playerList, Banker banker, int player, int dice,WriteFile writeFile,int count) throws IOException {
		playerList[player-1].setLocation(11);
		writeFile.move(player, playerList, dice, "went to jail");
		playerList[player-1].setWaitCount(1);
		return 0;
	}


	
}

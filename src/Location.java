import java.io.IOException;

/**
 * all properties are holding in this class
 * @author Ahmet Oruc
 *
 */
public abstract class Location implements Comparable<Location> {

	private String name;
	private int id;
	private int owner;
	/**
	 * player which came the location this function is specify what that player is going to do
	 * @param playerList
	 * @param banker
	 * @param player
	 * @param dice
	 * @param writeFile
	 * @param count
	 * @return
	 * @throws IOException
	 */
	public abstract int run(Player[] playerList,Banker banker,int player,int dice,WriteFile writeFile,int count) throws IOException;
	
	public int compareTo(Location o) {
		return this.name.compareTo(o.name);
		
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getOwner() {
		return owner;
	}
	
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

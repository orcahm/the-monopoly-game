/**
 * class which is holding bank's properties
 * @author orcahm
 *
 */
public class Banker{

	private int money;
	
	public Banker(){
		this.setMoney(100000);
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	public void changeMoney(int money){
		this.money += money;
	}
}

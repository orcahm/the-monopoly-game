/**
 * All locations which can be buy is child of this class
 * @author Ahmet Oruc
 *
 */
public abstract class Property  extends Location{

	private double cost;
	private int rent;

	public abstract void rentCalculation();

	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}
	
}

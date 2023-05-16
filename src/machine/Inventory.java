package machine;

public class Inventory {
	protected String name;
	protected int amount;
	
	public Inventory(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return amount + " " + name;
	}
}

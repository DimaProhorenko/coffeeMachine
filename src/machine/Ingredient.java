package machine;

public class Ingredient {
	private final String name;
	private int amount;
	private final String unit;
	
	
	public Ingredient(String name, String unit, int amount) {
		this.name = name;
		this.unit = unit;
		this.amount = amount;
	}
	
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return String.format("%d %s of %s", amount, unit, name);
	}
}

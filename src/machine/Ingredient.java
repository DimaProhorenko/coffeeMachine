package machine;

public class Ingredient extends Inventory {
	private String unit;
	
	
	public Ingredient(String name, String unit, int amount) {
		super(name, amount);
		this.unit = unit;
	}
	
	
	
	
	public String toString() {
		return String.format("%d %s of %s", amount, unit, name);
	}
}

package coffee;

public abstract class Coffee {
	protected String name;
	protected int price;
	protected int amountOfWater;
	protected int amountOfMilk;
	protected int amountOfBeans;
	
	public Coffee(String name, int price, int amountOfWater, int amountOfMilk, int amountOfBeans) {
		this.name = name;
		this.price = price;
		this.amountOfWater = amountOfWater;
		this.amountOfMilk = amountOfMilk;
		this.amountOfBeans = amountOfBeans;
	}
	
	public String getName() { return name; }
	
	public int getPrice() { return price; }
	
	public int getAmountOfWater() { return amountOfWater; }
	
	public int getAmountOfMilk() { return amountOfMilk; }
	
	public int getAmountOfBeans() { return amountOfBeans; }
}

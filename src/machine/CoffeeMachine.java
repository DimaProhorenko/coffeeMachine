package machine;
import java.util.List;
import coffee.*;

public class CoffeeMachine {
	private int money;
	private static final int ONE_CUP_WATER = 200;
	private static final int ONE_CUP_MILK = 50;
	private static final int ONE_CUP_BEANS = 15;
	private final List<Inventory> availableInventory;
	private int producibleCups = 0;
	
	public CoffeeMachine(List<Inventory> availableInventory, int money) {
		this.availableInventory = availableInventory;
		this.money = money;
		producibleCups = calcNumberOfCups();
	}
	
	public void showInventory() {
		System.out.println("The coffee machine has: ");
		availableInventory.forEach(System.out::println);
		System.out.println("$" + money + " of money");
	}
	
	public Inventory[] calcIngredients(int cups) {
		int waterAmount = ONE_CUP_WATER * cups;
		int milkAmount = ONE_CUP_MILK * cups;
		int beansAmount = ONE_CUP_BEANS * cups;
		
		Ingredient water = new Ingredient("water", "ml", waterAmount);
		Ingredient milk = new Ingredient("milk", "ml", milkAmount);
		Ingredient beans = new Ingredient("coffee beans", "g", beansAmount);
		Inventory dispCups = new Inventory("disposable cups", 1);
		
		return new Inventory[] {water, milk, beans, dispCups};
	}
	
	public void showIfEnoughEngridients(int numOfCups) {
		if (!checkIfCanMakeCoffee(numOfCups)) {
			System.out.printf("No, I can only make %d cup(s) of coffee\n", producibleCups);
		} else {
			if (numOfCups == producibleCups) {
				System.out.println("Yes, I can make that amount of coffee");
			} else {
				System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", producibleCups - numOfCups);
			}
		}
	}
	
	public void getMoney() {
		System.out.printf("I gave you $%d\n", money);
		money = 0;
	}
	
	public void fill(List<Inventory> inventory) {
		for (int i = 0; i < availableInventory.size(); i++) {
			Inventory currentIngredient = availableInventory.get(i);
			int currentAmmount = currentIngredient.getAmount();
			currentIngredient.setAmount(currentAmmount + inventory.get(i).getAmount());
		}
	}
	
	public void makeCoffee(int type) {
		Coffee coffee;
		switch(type) {
		case 2:
			coffee = new Latte();
			break;
		case 3:
			coffee = new Cappuccino();
			break;
		default:
			coffee = new Espresso();
			break;
		}
		
		String isEnough = checkIfEnoughInventory(coffee);
		
		if(isEnough.length() == 0) {
			reduceInventoryAmount(coffee);
			System.out.println("I have enough resources, making you a coffee!");
		} else {
			System.out.println(isEnough);
		}
	}
	
	private void reduceInventoryAmount(Coffee coffee) {
		for(int i = 0; i < availableInventory.size(); i++) {
			Inventory currentInv = availableInventory.get(i);
			int currentAmount = currentInv.getAmount();
			currentInv.setAmount(currentAmount - coffee.getAllAmount()[i]);
		}
		money += coffee.getPrice();
	}
	
	private String checkIfEnoughInventory(Coffee coffee) {
		String result = "";
		
		for (int i = 0; i < availableInventory.size(); i++) {
			Inventory current = availableInventory.get(i);
			if (current.getAmount() < coffee.getAllAmount()[i]) {
				result = String.format("Sorry, not enough %s!", current.getName());
				break;
			}
		}
		
		return result;
		
	}
	
	
	private boolean checkIfCanMakeCoffee(int numOfRequiredCups) {
		if (numOfRequiredCups <= producibleCups) {
			return true;
		}
		return false;
		
	}
	
	private int calcNumberOfCups() {
		int maxCupsWater = availableInventory.get(0).getAmount() / ONE_CUP_WATER;
		int maxCupsMilk = availableInventory.get(1).getAmount() / ONE_CUP_MILK;
		int maxCupsBeans = availableInventory.get(2).getAmount() / ONE_CUP_BEANS;
		return Math.min(Math.min(maxCupsWater, maxCupsMilk), maxCupsBeans);
	}
}

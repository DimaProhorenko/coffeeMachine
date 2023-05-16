package machine;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CoffeeMachineDriver {
	private final Scanner scanner = new Scanner(System.in);
	
	public final List<Inventory> availableInventory = new ArrayList<Inventory>();
	
	public CoffeeMachineDriver() {
		setDefaultAvailableIngredients();
	}
	
	public void setDefaultAvailableIngredients() {
		availableInventory.add(new Ingredient("water", "ml", 400));
		availableInventory.add(new Ingredient("milk", "ml", 540));
		availableInventory.add(new Ingredient("coffee beans", "g", 120));
		availableInventory.add(new Inventory("disposable cups", 9));
	}
	
	public List<Inventory> getFillIngredients() {
		System.out.println("Write how many ml of water you want to add:");
		int water = scanner.nextInt();
		System.out.println("Write how many ml of milk you want to add:");
		int milk = scanner.nextInt();
		System.out.println("Write how many grams of coffee beans you want to add:");
		int beans = scanner.nextInt();
		System.out.println("Write how many of disposable cups you want to add: ");
		int cups = scanner.nextInt();
		scanner.nextLine();
		List<Inventory> inventory = new ArrayList<>();
		inventory.add(new Ingredient("water", "ml", water));
		inventory.add(new Ingredient("milk", "ml", milk));
		inventory.add(new Ingredient("coffee beans", "g", beans));
		inventory.add(new Inventory("disposable cups", cups));
		return inventory;
	}
	
	public int getCupsNumberFromUser() {
		System.out.println("Write how many cups of coffee you will need: ");
		int cups = scanner.nextInt();
		return cups;
	}
	
	public void displayRequiredIngredients(int n, Inventory[] inventory) {
		System.out.println(String.format("For %d cups of coffee you will need:", n));
		for(Inventory ing:inventory) {
			System.out.println(ing);
		}
	}
	
	public String getUserInputForMenu() {
		System.out.println("Write action (buy, fill, take, remaining, exit): ");
		String choise = scanner.nextLine();
		return choise;
	}
	
	public int getTypeOfCoffeeFromUser() {
		String correctType = "1 2 3 back";
		String choise = "s";
		while (!correctType.contains(choise)) {
			System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
			choise = scanner.next();
			scanner.nextLine();
		}
		
		if(choise.equals("back")) {
			return 0;
		}
		return Integer.parseInt(choise);
	}
	
	
	
	public static void main(String[] args) {
		CoffeeMachineDriver cmd = new CoffeeMachineDriver();
		CoffeeMachine cm = new CoffeeMachine(cmd.availableInventory, 550);
		boolean isMachineOn = true;
		while(isMachineOn) {
			String nextAction = cmd.getUserInputForMenu();
			switch(nextAction) {
			case "take":
				cm.getMoney();
				break;
			case "fill":
				cm.fill(cmd.getFillIngredients());
				break;
			case "buy":
				int typeOfCoffee = cmd.getTypeOfCoffeeFromUser();
				if (typeOfCoffee > 0) {
					cm.makeCoffee(typeOfCoffee);
				}
				break;
			case "remaining":
				cm.showInventory();
				break;
			case "exit":
				isMachineOn = false;
				break;
			default:
				System.out.println("Wrong input");
			}
		}
	}
}

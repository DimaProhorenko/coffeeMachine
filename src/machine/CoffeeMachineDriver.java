package machine;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CoffeeMachineDriver {
	private final Scanner scanner = new Scanner(System.in);
	
	public final List<Ingredient> availableIngredients = new ArrayList<Ingredient>();
	
	
	public void getAvailableIngredients() {
		System.out.println("Write how many ml of water the coffee machine has:");
		int water = scanner.nextInt();
		System.out.println("Write how many ml of milk the coffee machine has:");
		int milk = scanner.nextInt();
		System.out.println("Write how many grams of coffee beans the coffee machine has:");
		int beans = scanner.nextInt();
		availableIngredients.add(new Ingredient("water", "ml", water));
		availableIngredients.add(new Ingredient("milk", "ml", milk));
		availableIngredients.add(new Ingredient("coffee beans", "g", beans));
	}
	
	public int getCupsNumberFromUser() {
		System.out.println("Write how many cups of coffee you will need: ");
		int cups = scanner.nextInt();
		return cups;
	}
	
	public void displayRequiredIngredients(int n, Ingredient[] ingredients) {
		System.out.println(String.format("For %d cups of coffee you will need:", n));
		for(Ingredient ing:ingredients) {
			System.out.println(ing);
		}
	}
	
	
	
	public static void main(String[] args) {
		CoffeeMachineDriver cmd = new CoffeeMachineDriver();
		cmd.getAvailableIngredients();
		int cups = cmd.getCupsNumberFromUser();
		CoffeeMachine cm = new CoffeeMachine(cmd.availableIngredients);
		cm.showIfEnoughEngridients(cups);
		
	}
}

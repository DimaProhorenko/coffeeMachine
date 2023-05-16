package machine;
import java.util.List;

public class CoffeeMachine {
	private static final int ONE_CUP_WATER = 200;
	private static final int ONE_CUP_MILK = 50;
	private static final int ONE_CUP_BEANS = 15;
	private final List<Ingredient> availableIngredients;
	private int producibleCups = 0;
	
	public CoffeeMachine(List<Ingredient> availaIngredients) {
		this.availableIngredients = availaIngredients;
		producibleCups = calcNumberOfCups();
	}
	
	public Ingredient[] calcIngredients(int cups) {
		int waterAmount = ONE_CUP_WATER * cups;
		int milkAmount = ONE_CUP_MILK * cups;
		int beansAmount = ONE_CUP_BEANS * cups;
		
		Ingredient water = new Ingredient("water", "ml", waterAmount);
		Ingredient milk = new Ingredient("milk", "ml", milkAmount);
		Ingredient beans = new Ingredient("coffee beans", "g", beansAmount);
		
		return new Ingredient[] {water, milk, beans};
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
	
	private boolean checkIfCanMakeCoffee(int numOfRequiredCups) {
		if (numOfRequiredCups <= producibleCups) {
			return true;
		}
		return false;
		
	}
	
	private int calcNumberOfCups() {
		int maxCupsWater = availableIngredients.get(0).getAmount() / ONE_CUP_WATER;
		int maxCupsMilk = availableIngredients.get(1).getAmount() / ONE_CUP_MILK;
		int maxCupsBeans = availableIngredients.get(2).getAmount() / ONE_CUP_BEANS;
		return Math.min(Math.min(maxCupsWater, maxCupsMilk), maxCupsBeans);
	}
}

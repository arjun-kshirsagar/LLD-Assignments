package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		

		
		// Beverage coffee = new Cappuccino();
        // System.out.println("Coffee");
		// System.out.println(coffee.cost());


		Beverage coffee = new BaseCoffee(); 							// 10
		Beverage capuccino = new Cappuccino(coffee); 					// +10
		System.out.println("Cappuccino: " + capuccino.cost());

		coffee = new BaseCoffee(); 										// 10
		Beverage coffeeWithMilk = new Milk(coffee);          			// +5
		Beverage coffeeWithMocha = new Mocha(coffeeWithMilk);      	 	// +10
		Beverage coffeeWithSugar = new Sugar(coffeeWithMocha);			// +30
		Beverage latte = new Latte(coffeeWithSugar);					// +20
		System.out.println("Latte with toppings: " + latte.cost());


	}

}
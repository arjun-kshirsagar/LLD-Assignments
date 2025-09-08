package beverages_decorator;

public class Latte extends Beverage {
	private Beverage beverage;
	public Latte(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public int cost() {
		System.out.println("Latte: 20");
		return 20 + beverage.cost();
	}

}
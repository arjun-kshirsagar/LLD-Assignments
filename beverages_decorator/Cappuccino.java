package beverages_decorator;

public class Cappuccino extends Beverage{
	private Beverage beverage;
	public Cappuccino(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public int cost() {
		System.out.println("Cappuccino: 10");
		return 10 + beverage.cost();
	}
}
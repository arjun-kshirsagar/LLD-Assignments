package beverages_decorator;

public class Mocha extends Beverage {
    private Beverage beverage;
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        System.out.println("Mocha: 30");
        return 30 + beverage.cost();
    }
}

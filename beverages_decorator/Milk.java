package beverages_decorator;

public class Milk extends Beverage {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        System.out.println("Milk: 5");
        return 5 + beverage.cost();
    }
}

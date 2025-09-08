package beverages_decorator;

public class Sugar extends Beverage {
    private Beverage beverage;
    public Sugar(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        System.out.println("Sugar: 2");
        return 2 + beverage.cost();
    }
}

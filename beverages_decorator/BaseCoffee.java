package beverages_decorator;

public class BaseCoffee extends Beverage {
    @Override
    public int cost() {
        System.out.println("Base Coffee: 10");
        return 10;
    }
}

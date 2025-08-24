public class Demo08 {
    public static void main(String[] args) {
        System.out.println("=== Bicycle Demo ===");
        Bicycle bike = new Bicycle();
        bike.pedal(50);
        
        System.out.println("\n=== Car Demo ===");
        Car car = new Car();
        car.startEngine();
        car.recharge(10);
        car.stopEngine();
    }
}

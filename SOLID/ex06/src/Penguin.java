public class Penguin extends Bird {
    // Penguins don't fly, so they don't implement Flyable
    public void swim() {
        System.out.println("Swimming!");
    }
}
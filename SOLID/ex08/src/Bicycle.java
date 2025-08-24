public class Bicycle implements HumanPowered {
    @Override
    public void pedal(int effort) { 
        System.out.println("Pedal effort: " + effort); 
    }
}
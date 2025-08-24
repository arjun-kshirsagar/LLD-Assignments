public class Demo06 {
    public static void main(String[] args) {
        Aviary aviary = new Aviary();
        
        // Release a sparrow (can fly)
        aviary.release(new Sparrow());
        
        // Release a penguin (can't fly, but can swim)
        aviary.release(new Penguin());
    }
}

class Aviary {
    public void release(Flyable flyableBird) { 
        flyableBird.fly(); 
        System.out.println("Released"); 
    }
    
    public void release(Penguin penguin) {
        penguin.swim();
        System.out.println("Released penguin to swim");
    }
}
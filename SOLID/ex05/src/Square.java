
public class Square implements Shape {
    private int side;

    @Override
    public void setDimensions(int... dimensions) {
        if (dimensions.length != 1) {
            throw new IllegalArgumentException("Square requires exactly 1 dimension");
        }
        this.side = dimensions[0];
    }

    @Override
    public int area() {
        return side * side;
    }
    
    // Additional convenience method specific to Square
    public void setSide(int side) {
        this.side = side;
    }
}
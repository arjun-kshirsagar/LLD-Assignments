public class Rectangle implements Shape {
    protected int width;
    protected int height;

    @Override
    public void setDimensions(int... dimensions) {
        if (dimensions.length != 2) {
            throw new IllegalArgumentException("Rectangle requires exactly 2 dimensions");
        }
        this.width = dimensions[0];
        this.height = dimensions[1];
    }

    @Override
    public int area() { 
        return width * height; 
    }

    // Additional convenience methods specific to Rectangle
    public void setWidth(int width) { 
        this.width = width; 
    }

    public void setHeight(int height) { 
        this.height = height; 
    }
}

public class Demo05 {
    static int areaAfterResize(Shape shape, int... dimensions) {
        shape.setDimensions(dimensions);
        return shape.area();
    }
    
    public static void main(String[] args) {
        // Test with Rectangle
        Rectangle rectangle = new Rectangle();
        System.out.println("Rectangle area after resize: " + 
            areaAfterResize(rectangle, 5, 4)); // Should print 20
            
        // Test with Square
        Square square = new Square();
        System.out.println("Square area after resize: " + 
            areaAfterResize(square, 5)); // Should print 25
            
        // Demonstrate using the convenience methods
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        System.out.println("Rectangle with specific dimensions: " + rectangle.area());
        
        square.setSide(7);
        System.out.println("Square with specific side: " + square.area());
    }
}

public class Demo09 {
    public static void main(String[] args) {
        // Using SQL repository
        OrderRepository sqlRepo = new SqlOrderRepository();
        OrderController sqlController = new OrderController(sqlRepo);
        sqlController.create("ORD-1");
        
        // If we want to use a different repository, we can easily swap it
        OrderRepository inMemoryRepo = new InMemoryOrderRepository();
        OrderController inMemoryController = new OrderController(inMemoryRepo);
        inMemoryController.create("ORD-2");
    }
}

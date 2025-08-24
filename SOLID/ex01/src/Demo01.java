public class Demo01 {
    public static void main(String[] args) {
        // We can inject Email or SMS (flexible)
        Notifier email = new EmailClient();
        Notifier sms = new SmsClient();

        Taxation taxation = new TaxationImpl();

        OrderService order1 = new OrderService(email, taxation);
        order1.checkout("a@shop.com", 100.0);

        OrderService order2 = new OrderService(sms, taxation);
        order2.checkout("9876543210", 200.0);
    }
}

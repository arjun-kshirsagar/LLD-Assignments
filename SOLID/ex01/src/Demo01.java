public class Demo01 {
    public static void main(String[] args) {
        // We can inject Email or SMS (flexible)
        Notifier email = new EmailClient();
        Notifier sms = new SmsClient();

        OrderService order1 = new OrderService(email);
        order1.checkout("a@shop.com", 100.0);

        OrderService order2 = new OrderService(sms);
        order2.checkout("9876543210", 200.0);
    }
}

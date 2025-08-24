// Low-level module 1
class EmailClient implements Notifier {
    @Override
    public void send(String to, String message) {
        System.out.println("[EMAIL to=" + to + "] " + message);
    }
}

// Low-level module 2
class SmsClient implements Notifier {
    @Override
    public void send(String to, String message) {
        System.out.println("[SMS to=" + to + "] " + message);
    }
}

package com.example.notifications;

public class SmsDecorator extends NotifierDecorator {
    private String phoneNumber;
    private Notifier notifier;

    public SmsDecorator(Notifier notifier, String phoneNumber) {
        this.notifier = notifier;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String message) {
        notifier.notify(message);
        System.out.println("Sending SMS notification to " + phoneNumber + ": " + message);
    }
    
}

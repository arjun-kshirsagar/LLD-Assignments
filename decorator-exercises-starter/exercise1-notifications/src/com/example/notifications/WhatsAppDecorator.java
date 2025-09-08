package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private Notifier notifier;
    private String message;

    public WhatsAppDecorator(Notifier notifier, String message) {
        this.notifier = notifier;
        this.message = message;
    }

    public void notify(String message) {
        notifier.notify(message);
        System.out.println("WhatsApp Notification: " + message);
    }
}

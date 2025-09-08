package com.example.notifications;

public class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator() {}

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void notify(String text) {
        notifier.notify(text);
    }
    
}
package com.example.notifications;

public class SlackDecorator extends NotifierDecorator {
    private Notifier notifier;
    private String message;

    public SlackDecorator(Notifier notifier, String message) {
        this.notifier = notifier;
    }

    @Override
    public void notify(String message) {
        notifier.notify(message);
        System.out.println("Sending Slack notification: " + message);
    }
}

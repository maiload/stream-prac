package org.example.chapter10.service;

import org.example.chapter10.model.User4;

public class EmailSender {
    private EmailProvider emailProvider;

    public EmailSender setEmailProvider(EmailProvider emailProvider) {
        this.emailProvider = emailProvider;
        return this;
    }

    public void sendEmail(User4 user) {
        String email = emailProvider.getEmail(user);
        System.out.println("Sending " + email);
    }
}

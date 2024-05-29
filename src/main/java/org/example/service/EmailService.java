package org.example.service;

import org.example.model.User2;

public class EmailService {
    public void sendPlayWithFriendsEmail(User2 user) {
        user.getEmailAddress2().ifPresent(email -> System.out.println("Sending 'Play with Friends' email to " + email));
    }

    public void sendMakeMoreFriendsEmail(User2 user) {
        user.getEmailAddress2().ifPresent(email -> System.out.println("Sending 'Make more Friends' email to " + email));
    }

    public void sendVerifyYourEmailEmail(User2 user) {
        user.getEmailAddress2().ifPresent(email -> System.out.println("Sending 'Verify your Email' email to " + email));
    }
}

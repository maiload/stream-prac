package org.example.chapter10;

import org.example.chapter10.model.User4;
import org.example.chapter10.service.EmailProvider;
import org.example.chapter10.service.EmailSender;
import org.example.chapter10.service.MakeMoreFriendsEmailProvider;
import org.example.chapter10.service.VerifyYourEmailAddressEmailProvider;

import java.util.Arrays;
import java.util.List;

public class Chapter10_3 {
    public static void main(String[] args) {
        // Strategy Pattern
        User4 user1 = User4.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@fastcampus.co.kr";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
                }).build();
        User4 user2 = User4.builder(2, "Bob")
                .with(builder -> {
                    builder.emailAddress = "bob@fastcampus.co.kr";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(212, 213, 214);
                }).build();
        User4 user3 = User4.builder(3, "Charlie")
                .with(builder -> {
                    builder.emailAddress = "charlie@fastcampus.co.kr";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212);
                }).build();
        List<User4> users = Arrays.asList(user1, user2, user3);

        EmailSender emailSender = new EmailSender();
        EmailProvider verifyYourEmailAddressEmailProvider = new VerifyYourEmailAddressEmailProvider();
        EmailProvider makeMoreFriendsEmailProvider = new MakeMoreFriendsEmailProvider();

        emailSender.setEmailProvider(verifyYourEmailAddressEmailProvider);
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(makeMoreFriendsEmailProvider);
        users.stream()
                .filter(User4::isVerified)
                .filter(user -> user.getFriendUserIds().size() <= 5)
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(user -> "'Play with Friends' email for " + user.getName());
        users.stream()
                .filter(User4::isVerified)
                .filter(user -> user.getFriendUserIds().size() > 5)
                .forEach(emailSender::sendEmail);
    }
}

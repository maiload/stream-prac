package org.example.chapter10;

import org.example.chapter10.model.User4;
import org.example.chapter10.service.InternalUserService;
import org.example.chapter10.service.UserService;
import org.example.chapter10.service.UserServiceInFunctionalWay;

import java.util.Arrays;

public class Chapter10_4 {
    public static void main(String[] args) {
        // Template Method Pattern
        User4 alice = User4.builder(1, "Alice")
                .with(builder -> {
//                    builder.emailAddress = "alice@fastcampus.co.kr";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
                }).build();

        UserService userService = new UserService();
        InternalUserService internalUserService = new InternalUserService();

        userService.createUser(alice);
        internalUserService.createUser(alice);

        System.out.println("====================");

        UserServiceInFunctionalWay userServiceInFunctionalWay = new UserServiceInFunctionalWay(
                user -> {
                    System.out.println("Validating user " + user.getName());
                    return user.getName() != null && user.getEmailAddress2().isPresent(); },
                user -> {
                    System.out.println("Writing user " + user.getName() + " to DB");
                }
        );
        userServiceInFunctionalWay.createUser(alice);
    }
}

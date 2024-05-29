package org.example.chapter8;

import org.example.model.User2;
import org.example.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter8_10 {
    public static void main(String[] args) {
        // ParallelStream
        User2 user1 = new User2()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");
        User2 user2 = new User2()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");
        User2 user3 = new User2()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr");
        User2 user4 = new User2()
                .setId(104)
                .setName("David")
                .setEmailAddress("david@fastcampus.co.kr")
                .setVerified(true);
        User2 user5 = new User2()
                .setId(105)
                .setName("Eve")
                .setEmailAddress("eve@fastcampus.co.kr")
                .setVerified(false);
        User2 user6 = new User2()
                .setId(106)
                .setName("Frank")
                .setEmailAddress("frank@fastcampus.co.kr")
                .setVerified(false);

        List<User2> users = Arrays.asList(user1, user2, user3, user4, user5, user6);

        long startTime = System.currentTimeMillis();
        EmailService emailService = new EmailService();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmailEmail);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        users.stream().parallel()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmailEmail);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel: " + (endTime - startTime) + "ms");


        // 순서가 유지되는 자료형으로 종결 처리하면 순차적 처리와 일치하게 종결된다
        List<User2> processedUsers = users.parallelStream()
                .map(user -> {
                    System.out.println("Capitalize user name for user " + user.getId());
                    user.setName(user.getName().toUpperCase());
                    return user;
                })
                .map(user -> {
                    System.out.println("Set 'isVerified' to true for user" + user.getId());
                    user.setVerified(true);
                    return user;
                })
                .collect(Collectors.toList());
        System.out.println(processedUsers);
    }
}

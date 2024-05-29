package org.example.chapter8;

import org.example.model.User2;
import org.example.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Chapter8_9 {
    public static void main(String[] args) {
        // forEach
        List<Integer> numbers = Arrays.asList(3, 5, 2, 1);
        numbers.stream().forEach(number -> System.out.println(number));
        numbers.forEach(System.out::println);

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

        List<User2> users = Arrays.asList(user1, user2, user3);
        EmailService emailService = new EmailService();

        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmailEmail);



        for (int i = 0; i < users.size(); i++) {
            User2 user = users.get(i);
            System.out.println("Do an operation on user " + user.getName() + " at index " + i);
        }
        IntStream.range(0, users.size()).forEach(i -> {
                    User2 user = users.get(i);
                    System.out.println("Do an operation on user " + user.getName() + " at index " + i);
                });
    }
}

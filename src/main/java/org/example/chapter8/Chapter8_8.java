package org.example.chapter8;

import org.example.model.User2;
import org.example.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Chapter8_8 {
    public static void main(String[] args) {
        // partitioningBy
        List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203);
        Map<Boolean, List<Integer>> numberPartitions = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));
        System.out.println(numberPartitions);
        System.out.println("Even number: " + numberPartitions.get(true));
        System.out.println("Odd number: " + numberPartitions.get(false));

        User2 user1 = new User2()
                .setId(101)
                .setName("Alice")
                .setEmailAddress("alice@fastcampus.co.kr")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214));
        User2 user2 = new User2()
                .setId(102)
                .setName("Bob")
                .setEmailAddress("bob@fastcampus.co.kr")
                .setFriendUserIds(Arrays.asList(204, 205, 206));
        User2 user3 = new User2()
                .setId(103)
                .setName("Charlie")
                .setEmailAddress("charlie@fastcampus.co.kr")
                .setFriendUserIds(Arrays.asList(204, 205, 207, 218));

        List<User2> users = Arrays.asList(user1, user2, user3);
        Map<Boolean, List<User2>> userPartitions = users.stream()
                .collect(Collectors.partitioningBy(user -> user.getFriendUserIds().size() > 5));

        EmailService emailService = new EmailService();

        for (User2 user : userPartitions.get(true)) {
            emailService.sendPlayWithFriendsEmail(user);
        }

        for (User2 user : userPartitions.get(false)) {
            emailService.sendMakeMoreFriendsEmail(user);
        }
    }
}

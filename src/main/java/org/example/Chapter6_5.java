package org.example;

import org.example.model.Order;
import org.example.model.User2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class Chapter6_5 {
    public static void main(String[] args) {
        // sorted
        List<Integer> list = List.of(3, -5, 7, 4);
        List<Integer> sortedList = list.stream().sorted().toList();
        System.out.println(sortedList);

        User2 user1 = new User2()
                .setId(101)
                .setName("Paul")
                .setVerified(true)
                .setEmailAddress("alice@email.co.kr");

        User2 user2 = new User2()
                .setId(102)
                .setName("David")
                .setVerified(false)
                .setEmailAddress("bob@email.co.kr");

        User2 user3 = new User2()
                .setId(103)
                .setName("John")
                .setVerified(false)
                .setEmailAddress("charlie@email.co.kr");

        List<User2> users = Arrays.asList(user1, user2, user3);
        List<User2> sortedUsers = users.stream()
                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .toList();
        System.out.println(sortedUsers);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103)
                .setCreatedAt(now.minusHours(1));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102)
                .setCreatedAt(now.minusHours(36));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104)
                .setCreatedAt(now.minusHours(25));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(10));

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Order> sortedOrders = orders.stream()
                .sorted((o1, o2) -> o1.getCreatedAt().compareTo(o2.getCreatedAt()))
                .toList();
        System.out.println(sortedOrders);
    }
}

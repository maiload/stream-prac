package org.example.chapter6;

import org.example.model.Order;
import org.example.model.User2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter6_4 {
    public static void main(String[] args) {
        User2 user1 = new User2()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@email.co.kr");

        User2 user2 = new User2()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@email.co.kr");

        User2 user3 = new User2()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@email.co.kr");

        List<User2> users = Arrays.asList(user1, user2, user3);
        List<String> emails = users.stream()
                .filter(user -> !user.isVerified())
                .map(User2::getEmailAddress)
                .collect(Collectors.toList());
        System.out.println(emails);

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
        List<Long> userIds = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(userIds);

        List<Order> ordersInErrorStatusIn24hrs = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .filter(order -> order.getCreatedAt().isAfter(now.minusHours(24)))
                .collect(Collectors.toList());
        System.out.println(ordersInErrorStatusIn24hrs);
    }
}

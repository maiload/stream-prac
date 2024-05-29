package org.example.chapter6;

import org.example.model.Order;
import org.example.model.User2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6_2 {
    public static void main(String[] args) {
        // Filter
        Stream<Integer> numberStream2 = Stream.of(3, -5, 7, 10, -3);
        Stream<Integer> filteredNumberStream = numberStream2.filter(x -> x > 0);
        List<Integer> filteredNumbers = filteredNumberStream.collect(Collectors.toList());
        System.out.println(filteredNumbers);

        List<Integer> filteredNumbers2 = Stream.of(3, -5, 7, 10, -3)
                .filter(x -> x > 0)
                .collect(Collectors.toList());


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
        List<User2> verifiedUsers = users.stream()
                .filter(User2::isVerified)
                .collect(Collectors.toList());
        System.out.println(verifiedUsers);

        List<User2> unverifiedUsers = users.stream()
                .filter(user -> !user.isVerified())
                .collect(Collectors.toList());
        System.out.println(unverifiedUsers);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Order> filteredOrders = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .collect(Collectors.toList());
        System.out.println(filteredOrders);
    }
}

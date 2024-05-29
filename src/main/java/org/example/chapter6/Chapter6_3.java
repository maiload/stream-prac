package org.example.chapter6;

import org.example.model.Order;
import org.example.model.User2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter6_3 {
    public static void main(String[] args) {
        // map
        List<Integer> numberList = List.of(1, 2, -4);
        List<Integer> numberListX2 = numberList.stream()
                .map(x -> 2 * x)
                .collect(Collectors.toList());
        System.out.println(numberListX2);

        List<String> numberListStream = numberList.stream()
                .map(x -> "Number is " + x)
                .collect(Collectors.toList());
        System.out.println(numberListStream);

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
        List<String> emailAddresses = users.stream()
                .map(User2::getEmailAddress)
                .collect(Collectors.toList());
        System.out.println(emailAddresses);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Long> createByUserIds = orders.stream()
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(createByUserIds);
    }
}

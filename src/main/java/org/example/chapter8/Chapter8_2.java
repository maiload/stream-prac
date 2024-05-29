package org.example.chapter8;

import org.example.model.Order;
import org.example.model.User2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Chapter8_2 {
    public static void main(String[] args) {
        // allMatch, anyMatch
        List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
        boolean allPositive = numbers.stream().allMatch(x -> x > 0);
        System.out.println("Are all numbers positive: " + allPositive);

        boolean anyNegative = numbers.stream().anyMatch(x -> x < 0);
        System.out.println("Is any numbers negative: " + anyNegative);

        User2 user1 = new User2()
                .setId(101)
                .setName("David")
                .setVerified(true)
                .setEmailAddress("david@email.co.kr");

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

        List<User2> users = List.of(user1, user2, user3);
        boolean areAllUserVerified = users.stream().allMatch(User2::isVerified);
        System.out.println(areAllUserVerified);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setAmount(BigDecimal.valueOf(2000));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setAmount(BigDecimal.valueOf(4000));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setAmount(BigDecimal.valueOf(3000));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setAmount(BigDecimal.valueOf(7000));

        List<Order> orders = Arrays.asList(order1, order2, order3, order4);
        boolean isAnyOrderInErrorStatus = orders.stream()
                .anyMatch(order -> order.getStatus() == Order.OrderStatus.ERROR);
        System.out.println(isAnyOrderInErrorStatus);
    }
}

package org.example.chapter8;

import org.example.model.Order;
import org.example.model.User2;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Chapter8_1 {
    public static void main(String[] args) {
        // max, min, count
        Optional<Integer> max = Stream.of(5, 3, 6, 2, 1)
                .max((x, y) -> x - y);
        System.out.println(max.get());

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

        User2 user4 = new User2()
                .setId(104)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@email.co.kr");

        List<User2> users = List.of(user1, user2, user3, user4);

        User2 firstUser = users.stream()
                .min((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .get();
        System.out.println(firstUser);

        long positiveIntegerCount = Stream.of(1, -4, 5, -3, 6)
                .filter(x -> x > 0)
                .count();
        System.out.println(positiveIntegerCount);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        user1.setCreatedAt(now.minusHours(2));
        user2.setCreatedAt(now.minusHours(10));
        user3.setCreatedAt(now.minusHours(1));
        user4.setCreatedAt(now.minusHours(27));

        long unverifiedUsersIn24Hrs = users.stream()
                .filter(user -> user.getCreatedAt().isAfter(now.minusHours(24)))
                .filter(user -> !user.isVerified())
                .count();
        System.out.println(unverifiedUsersIn24Hrs);

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
        Order erroredOrderWithMaxAmount = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .max((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()))
                .get();
        System.out.println(erroredOrderWithMaxAmount);

        BigDecimal maxErroredAmount = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getAmount)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        System.out.println(maxErroredAmount);
    }
}

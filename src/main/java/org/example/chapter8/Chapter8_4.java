package org.example.chapter8;

import org.example.model.Order;
import org.example.model.OrderLine;
import org.example.model.User2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Chapter8_4 {
    public static void main(String[] args) {
        // reduce -> sum 을 구할 때 사용
        List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
        int sum = numbers.stream()
                .reduce((x, y) -> x + y)
                .get();
        System.out.println(sum);

        int min = numbers.stream()
                .reduce((x, y) -> x < y ? x : y)
                .get();
        System.out.println(min);

        int product = numbers.stream()
                .reduce(1, (x, y) -> x * y);
        System.out.println(product);

        List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
        Integer sumOfNumberStrList = numberStrList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x, y) -> x + y);
        System.out.println(sumOfNumberStrList);

        // reduce(초기값, 누적 함수, 결합 함수)
        // 결합 함수의 경우 병렬 스트림인 경우에만 사용됨
        int sumOfNumberStrList2 = numberStrList.stream()
                .reduce(0, (number, str) -> number + Integer.parseInt(str), (x, y) -> x + y);
        System.out.println(sumOfNumberStrList2);

        User2 user1 = new User2()
                .setId(101)
                .setName("David")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204));

        User2 user2 = new User2()
                .setId(102)
                .setName("Bob")
                .setFriendUserIds(Arrays.asList(204, 205, 206));

        User2 user3 = new User2()
                .setId(103)
                .setName("Charlie")
                .setFriendUserIds(Arrays.asList(204, 205, 207));

        List<User2> users = List.of(user1, user2, user3);
        int sumOfNumberOfFriends = users.stream()
                .map(User2::getFriendUserIds)
                .map(List::size)
                .reduce(0, (x, y) -> x + y);
        System.out.println(sumOfNumberOfFriends);

        Order order1 = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        Order order2 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))));
        Order order3 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        List<Order> orders = Arrays.asList(order1, order2, order3);
        BigDecimal sumOfAmount = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sumOfAmount);
    }
}

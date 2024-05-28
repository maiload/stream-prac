package org.example;

import org.example.model.User;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Chapter4 {
    public static void main(String[] args) {
        // Supplier<T>
        Supplier<String> myStringSupplier = () -> "Hello world!";
        System.out.println(myStringSupplier.get());

        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
        System.out.println(myRandomDoubleSupplier.get());

        printRandomDoubles(myRandomDoubleSupplier, 5);

        // Consumer<T>
        Consumer<String> myStringConsumer = (str) -> System.out.println(str);
        myStringConsumer.accept("Hello");

        List<Integer> integerInputs = Arrays.asList(4, 2, 3);   // immutableList
        Consumer<Integer> myIntegerProcessor = (x) -> System.out.println("Processing integer " + x);
        process(integerInputs, myIntegerProcessor);

        Consumer<Integer> myDifferentIntegerProcessor = (x) -> System.out.println("Processing integer in different way " + x);
        process(integerInputs, myDifferentIntegerProcessor);

        // process 라는 메서드에 다양한 함수를 매개변수로 넘겨 다양하게 사용할 수 있다.
        Consumer<Double> myDoubleProcessor = (x) -> System.out.println("Processing double " + x);
        List<Double> doubleInputs = Arrays.asList(1.1, 2.2, 3.3);
        process(doubleInputs, myDoubleProcessor);

        // BiConsumer<T, U>
        BiConsumer<Integer, Double> myDoubleProcessor2 = (index, input) -> System.out.println("Processing " + input + " at index " + index);
        List<Double> doubleInputs2 = Arrays.asList(1.1, 2.2, 3.3);
        process2(doubleInputs2, myDoubleProcessor2);

        // Predicate<T>
        Predicate<Integer> isPositive = (x) -> x > 0;
        System.out.println(isPositive.test(1));

        List<Integer> inputs = Arrays.asList(-1, 2, 6, 1, -5, 0);
        System.out.println("Positive numbers: " + filter(inputs, isPositive));
        System.out.println("Non-positive numbers: " + filter(inputs, isPositive.negate()));
        System.out.println("Non-negative numbers: " + filter(inputs, isPositive.or(x -> x == 0)));
        System.out.println("Positive even numbers: " + filter(inputs, isPositive.and(x -> x % 2 == 0)));

        // Comparator<T>
        List<User> users = new ArrayList<>();
        users.add(new User(3, "Alice"));
        users.add(new User(1, "Charlie"));
        users.add(new User(5, "Bob"));
        System.out.println(users);

        // id 순
        Comparator<User> idComparator = (u1, u2) -> u1.getId() - u2.getId();
        int result =  idComparator.compare(users.get(0), users.get(1));
        System.out.println(result);
        Collections.sort(users, idComparator);
        System.out.println(users);

        // name 순
        Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        System.out.println(users);
    }


    // 함수를 매개변수로 받는 메서드
    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }

    public static <T> void process(List<T> inputs, Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }

    public static <T> void process2(List<T> inputs, BiConsumer<Integer, T> processor) {
        for (int i = 0; i < inputs.size(); i++) {
            processor.accept(i, inputs.get(i));
        }
    }

    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition) {
        List<T> output = new ArrayList<>();
        for (T input : inputs) {
            if (condition.test(input)) {
                output.add(input);
            }
        }
        return output;
    }
}

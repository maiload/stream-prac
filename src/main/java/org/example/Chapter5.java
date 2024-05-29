package org.example;

import org.example.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Chapter5 {
    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public void myMethod() {
        System.out.println(calculate(10, 3, this::subtract));
    }

    public static void main(String[] args) {
        // className::staticMethodName
        int a = Integer.parseInt("15");
        Function<String, Integer> strToInt = Integer::parseInt;
        System.out.println(strToInt.apply("15"));

        String str = "hello";
        boolean b = str.equals("world");
        Predicate<String> equalsToHello = str::equals;
        System.out.println(equalsToHello.test("hello"));

        System.out.println(calculate(4, 6, Chapter5::multiply));

        // objectName::instanceMethodName
        Chapter5 instance = new Chapter5();
        System.out.println(calculate(6, 4, instance::subtract));

        // className::instanceMethodName
        Function<String, Integer> strLength = String::length;
        int length= strLength.apply("hello world");
        System.out.println(length);

        BiPredicate<String, String> strEquals = String::equals;
        System.out.println(strEquals.test("hello", "world"));

        List<User> users = new ArrayList<>();
        users.add(new User(3, "Alice"));
        users.add(new User(1, "Charlie"));
        users.add(new User(5, "Bob"));

        printUserField(users, User::getId);
        printUserField(users, User::getName);

        // className::new
        BiFunction<Integer, String, User> userCreator = User::new;
        User james = userCreator.apply(10, "James");


        Map<String, BiFunction<String, String, Car>> carTypeToConstructorMap = new HashMap<>();
        carTypeToConstructorMap.put("sedan", Sedan::new);
        carTypeToConstructorMap.put("suv", Suv::new);
        carTypeToConstructorMap.put("van", Van::new);

        String[][] inputs = new String[][] {
                { "sedan", "Sonata", "Hyundai" },
                { "sedan", "Accord", "Honda" },
                { "van", "Transit", "Ford" },
                { "suv", "Tucson", "Hyundai" }
        };

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            String[] input = inputs[i];
            String type = input[0];
            String name = input[1];
            String brand = input[2];
            Car car = carTypeToConstructorMap.get(type).apply(name, brand);
            cars.add(car);
        }

        for (Car car : cars) {
            car.drive();
        }
    }

    public static void printUserField(List<User> users, Function<User, Object> getter) {
        for (User user : users) {
            System.out.println(getter.apply(user));
        }
    }
}

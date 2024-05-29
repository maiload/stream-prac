package org.example.chapter9;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Chapter9_1 {
    public static void main(String[] args) {
        // Lexical Scope, Closure, Currying
        Supplier<String> supplier = getStringSupplier();
        System.out.println(supplier.get());

        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        int result = add.apply(3, 10);
        System.out.println(result);

        Function<Integer, Function<Integer, Integer>> curriedAdd = x -> (y -> x + y);
        Function<Integer, Integer> addThree = curriedAdd.apply(3);
        int result2 = addThree.apply(10);
        System.out.println(result2);
    }

    public static Supplier<String> getStringSupplier(){
        String hello = "Hello";
        Supplier<String> supplier = () -> {
            String world = "World";
            return hello + world;
        };

        return supplier;
    }
}

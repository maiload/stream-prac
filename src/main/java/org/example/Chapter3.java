package org.example;

import org.example.util.Adder;
import org.example.util.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Chapter3 {
    public static void main(String[] args) {
        // 함수를 Object 의 형태로 나타내기 -> 함수를 변수에 담기 (일급 객체)
        Function<Integer, Integer> myAdder = new Adder();
        int result = myAdder.apply(5);
        System.out.println(result);

        // 함수를 람다의 형식으로 변수에 담기
        Function<Integer, Integer> myAdder2 = (Integer x) -> { return x + 10; };
        int result2 = myAdder.apply(5);
        System.out.println(result2);

        // 람다식 축약
        Function<Integer, Integer> myAdder3 = x -> x + 10;
        int result3 = myAdder.apply(5);
        System.out.println(result3);

        // 매개변수가 2개인 람다식
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        int result4 = add.apply(5, 10);
        System.out.println(result4);

        // 매개변수가 3개인 람다식
        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers = (x, y, z) -> x + y + z;
        int result5 = addThreeNumbers.apply(3, 5, 7);
        System.out.println(result5);
    }
}

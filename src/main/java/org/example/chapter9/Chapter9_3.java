package org.example.chapter9;

import org.example.model.Order;
import org.example.model.OrderLine;
import org.example.priceprocessor.OrderLineAggregationPriceProcessor;
import org.example.priceprocessor.TaxPriceProcessor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Chapter9_3 {
    public static void main(String[] args) {
        // Function Composition
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> addTen = x -> x + 10;

        Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addTen);
        System.out.println(composedFunction.apply(3));

        Order unprocessedOrder = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        List<Function<Order, Order>> priceProcessors = getPriceProcessor(unprocessedOrder);

        Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
                .reduce(Function.identity(), Function::andThen);
        Order processedOrder = mergedPriceProcessors.apply(unprocessedOrder);
        System.out.println(processedOrder);
    }

    public static List<Function<Order, Order>> getPriceProcessor(Order order) {
        // 실제로는 order 의 성질에 따라 processor 들을 조합하여 반환
        return Arrays.asList(new OrderLineAggregationPriceProcessor(),
                new TaxPriceProcessor(new BigDecimal("9.375")));
    }
}

package org.example.priceprocessor;

import org.example.model.Order;
import org.example.model.OrderLine;

import java.math.BigDecimal;
import java.util.function.Function;

public class OrderLineAggregationPriceProcessor implements Function<Order, Order> {
    @Override
    public Order apply(Order order) {
        return order.setAmount(order.getOrderLines().stream()
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}

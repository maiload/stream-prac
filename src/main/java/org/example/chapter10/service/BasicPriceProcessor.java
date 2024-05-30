package org.example.chapter10.service;

import org.example.chapter10.model.Price;

public class BasicPriceProcessor implements PriceProcessor{
    @Override
    public Price process(Price price) {
        return price;
    }
}

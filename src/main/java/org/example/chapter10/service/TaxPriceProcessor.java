package org.example.chapter10.service;

import org.example.chapter10.model.Price;

public class TaxPriceProcessor implements PriceProcessor{
    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + ", then applied tax");
    }
}

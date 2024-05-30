package org.example.chapter10;

import org.example.chapter10.model.Price;
import org.example.chapter10.service.BasicPriceProcessor;
import org.example.chapter10.service.DiscountPriceProcessor;
import org.example.chapter10.service.PriceProcessor;
import org.example.chapter10.service.TaxPriceProcessor;

public class Chapter10_2 {
    public static void main(String[] args) {
        // Decorator Pattern
        Price unprocessedPrice = new Price("Original Price");

        PriceProcessor basicPriceProcessor = new BasicPriceProcessor();
        PriceProcessor discountPriceProcessor = new DiscountPriceProcessor();
        PriceProcessor taxtPriceProcessor = new TaxPriceProcessor();

        PriceProcessor decoratedPriceProcessor = basicPriceProcessor
                .andThen(discountPriceProcessor)
                .andThen(taxtPriceProcessor);
        Price processedPrice = decoratedPriceProcessor.process(unprocessedPrice);
        System.out.println(processedPrice.getPrice());


        PriceProcessor decoratedPriceProcessor2 = basicPriceProcessor
                .andThen(taxtPriceProcessor)
                .andThen(price -> new Price(price.getPrice() + ", then apply another procedure"));
        Price processedPrice2 = decoratedPriceProcessor2.process(unprocessedPrice);
        System.out.println(processedPrice2.getPrice());
    }
}

package org.example.chapter10.service;

import org.example.chapter10.model.Price;

@FunctionalInterface
public interface PriceProcessor {
    Price process(Price price);

    default PriceProcessor andThen(PriceProcessor next){
        // 반환 값이 함수이기 때문에 람다식으로 표현
        return price -> next.process(process(price));
    }
}

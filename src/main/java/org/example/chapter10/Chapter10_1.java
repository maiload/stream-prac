package org.example.chapter10;

import org.example.chapter10.model.User3;
import org.example.chapter10.model.User4;

public class Chapter10_1 {
    public static void main(String[] args) {
        // Builder
        User3 user3 = User3.builder(1, "Alice")
                .withEmailAddress("alice@email.com")
                .withIsVerified(false)
                .build();
        System.out.println(user3);


        User4 user4 = User4.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@email.com";
                    builder.isVerified = false;
                }).build();
        System.out.println(user4);
    }
}

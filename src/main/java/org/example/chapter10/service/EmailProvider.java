package org.example.chapter10.service;

import org.example.chapter10.model.User4;

@FunctionalInterface
public interface EmailProvider {
    String getEmail(User4 user);
}

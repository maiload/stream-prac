package org.example.chapter10.service;

import org.example.chapter10.model.User4;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class UserServiceInFunctionalWay {
    private final Predicate<User4> validateUser;
    private final Consumer<User4> writeToDB;

    public UserServiceInFunctionalWay(Predicate<User4> validateUser, Consumer<User4> writeToDB) {
        this.validateUser = validateUser;
        this.writeToDB = writeToDB;
    }

    public void createUser(User4 user) {
        if (validateUser.test(user)) {
            writeToDB.accept(user);
        } else {
            System.out.println("Cannot create user");
        }
    }
}

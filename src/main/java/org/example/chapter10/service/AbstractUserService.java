package org.example.chapter10.service;

import org.example.chapter10.model.User4;

public abstract class AbstractUserService {
    protected abstract boolean validateUser(User4 user);

    protected abstract void writeToDB(User4 user);

    public void createUser(User4 user) {
        if (validateUser(user)) {
            writeToDB(user);
        } else{
            System.out.println("Cannot create user");
        }
    }
}

package org.example.chapter10.service;

import org.example.chapter10.model.User4;

public class UserService extends AbstractUserService{
    @Override
    protected boolean validateUser(User4 user) {
        System.out.println("Validating user " + user.getName());
        return user.getName() != null && user.getEmailAddress2().isPresent();
    }

    @Override
    protected void writeToDB(User4 user) {
        System.out.println("Writing user " + user.getName() + " to DB");
    }
}

package org.example.chapter10.service;

import org.example.chapter10.model.User4;

public class InternalUserService extends AbstractUserService{
    @Override
    protected boolean validateUser(User4 user) {
        System.out.println("Validating internal user " + user.getName());
        return true;
    }

    @Override
    protected void writeToDB(User4 user) {
        System.out.println("Writing user " + user.getName() + " to internal DB");

    }
}

package org.example.chapter10.service;

import org.example.chapter10.model.User4;

public class MakeMoreFriendsEmailProvider implements EmailProvider{
    @Override
    public String getEmail(User4 user) {
        return "'Make More Friends' email for " + user.getName();
    }
}

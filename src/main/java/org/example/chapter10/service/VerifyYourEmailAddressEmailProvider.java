package org.example.chapter10.service;

import org.example.chapter10.model.User4;

public class VerifyYourEmailAddressEmailProvider implements EmailProvider{
    @Override
    public String getEmail(User4 user) {
        return "'Verify Your Email Address' email for " + user.getName();
    }
}

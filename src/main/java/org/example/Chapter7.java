package org.example;

import org.example.model.User;
import org.example.model.User2;

import java.util.Optional;

public class Chapter7 {
    public static void main(String[] args) {
        // Optional
        User2 user1 = new User2()
                .setId(1001)
                .setName("Alice")
                .setVerified(false);

        User2 user2 = new User2()
                .setId(1001)
                .setName("Alice")
                .setVerified(false)
                .setEmailAddress("alice@email.co.kr");

//        System.out.println("Same? : " + userEquals(user1, user2));

        String someEmail = "some@email.com";
        String nullEmail = null;

        Optional<String> maybeEmail = Optional.of(someEmail);
        Optional<String> maybeEmail2 = Optional.empty();
        Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
        Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail);

        String email = maybeEmail.get();
        System.out.println(email);

        if (maybeEmail2.isPresent()){
            System.out.println(maybeEmail2.get());
        }

        String defaultEmail = "default@email.com";
        String email3 = maybeEmail2.orElse(defaultEmail);
        System.out.println(email3);

        String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
        System.out.println(email4);

//        String email5 = maybeEmail2.orElseThrow(() -> new RuntimeException("email not present"));

        Optional<User2> maybeUser = Optional.ofNullable(maybeGetUser(true));
        maybeUser.ifPresent(user -> System.out.println(user));

        Optional<Integer> maybeId = Optional.ofNullable(maybeGetUser(true))
                .map(user -> user.getId());
        maybeId.ifPresent(id -> System.out.println(id));

        String userName = Optional.ofNullable(maybeGetUser(false))
                .map(User2::getName)
                .map(name -> "The name is " + name)
                .orElse("Name is empty");
        System.out.println(userName);

//        Optional<String> maybeEmail5 = Optional.ofNullable(maybeGetUser(true))
//                .flatMap(User2::getEmailAddress);
//        maybeEmail5.ifPresent(System.out::println);
    }

    public static boolean userEquals(User2 u1, User2 u2){
        return u1.getId() == u2.getId()
                && u1.getName().equals(u2.getName())
                && u1.getEmailAddress().equals(u2.getEmailAddress())
                && u1.isVerified() == u2.isVerified();
    }

    public static User2 maybeGetUser(boolean returnUser){
        if (returnUser){
            return new User2()
                    .setId(1001)
                    .setName("Alice")
                    .setVerified(false)
                    .setEmailAddress("alice@email.co.kr");
        } else {
            return null;
        }
    }
}

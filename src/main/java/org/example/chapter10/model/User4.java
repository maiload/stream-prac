package org.example.chapter10.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class User4 {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private LocalDateTime createdAt;
    private List<Integer> friendUserIds;

    public User4(Builder builder) {
         this.id = builder.id;
         this.name = builder.name;
         this.emailAddress = builder.emailAddress;
         this.isVerified = builder.isVerified;
         this.friendUserIds = builder.friendUserIds;
         this.createdAt = builder.createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public Optional<String> getEmailAddress2() {
        return Optional.ofNullable(emailAddress);
    }

    public boolean isVerified() {
        return isVerified;
    }

    public List<Integer> getFriendUserIds() {
        return friendUserIds;
    }

    public static Builder builder(int id, String name) {
        return new Builder(id, name);
    }

    public static class Builder {
         private int id;
         private String name;
         public String emailAddress;
         public boolean isVerified;
         public LocalDateTime createdAt;
         public List<Integer> friendUserIds = new ArrayList<>();

         private Builder (int id, String name) {
             this.id = id;
             this.name = name;
         }

         public Builder with(Consumer<Builder> consumer){
            consumer.accept(this);
            return this;
         }

        public User4 build() {
             return new User4(this);
        }
    }


    @Override
    public String toString() {
        return "User2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", isVerified=" + isVerified +
                ", friendUserIds=" + friendUserIds +
                ", createdAt=" + createdAt +
                '}';
    }
}

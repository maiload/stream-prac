package org.example.chapter10.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class User3 {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private LocalDateTime createdAt;
    private List<Integer> friendUserIds;

    public User3(Builder builder) {
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
         private String emailAddress;
         private boolean isVerified;
         private LocalDateTime createdAt;
         private List<Integer> friendUserIds = new ArrayList<>();

         private Builder (int id, String name) {
             this.id = id;
             this.name = name;
         }

         public Builder withEmailAddress(String emailAddress) {
             this.emailAddress = emailAddress;
             return this;
         }

         public Builder withIsVerified(boolean isVerified) {
              this.isVerified = isVerified;
              return this;
         }

         public Builder withFriendUserIds(List<Integer> friendUserIds) {
             this.friendUserIds = friendUserIds;
             return this;
         }

         public Builder withCreatedAt(LocalDateTime createdAt) {
             this.createdAt = createdAt;
             return this;
         }

        public User3 build() {
             return new User3(this);
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

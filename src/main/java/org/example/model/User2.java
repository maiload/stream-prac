package org.example.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class User2 {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private List<Integer> friendUserIds;
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User2 setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public int getId() {
        return id;
    }

    public User2 setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User2 setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public Optional<String> getEmailAddress2() {
        return Optional.ofNullable(emailAddress);
    }

    public User2 setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public User2 setVerified(boolean verified) {
        isVerified = verified;
        return this;
    }

    public List<Integer> getFriendUserIds() {
        return friendUserIds;
    }

    public User2 setFriendUserIds(List<Integer> friendUserIds) {
        this.friendUserIds = friendUserIds;
        return this;
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

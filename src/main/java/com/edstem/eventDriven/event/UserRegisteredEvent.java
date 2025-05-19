package com.edstem.eventDriven.event;

public class UserRegisteredEvent {
    private final Long userId;
    private final String userName;

    public UserRegisteredEvent(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}

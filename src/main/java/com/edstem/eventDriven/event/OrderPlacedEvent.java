package com.edstem.eventDriven.event;

public class OrderPlacedEvent {
    private final Long userId;
    private final Long orderId;

    public OrderPlacedEvent(Long userId, Long orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOrderId() {
        return orderId;
    }
}

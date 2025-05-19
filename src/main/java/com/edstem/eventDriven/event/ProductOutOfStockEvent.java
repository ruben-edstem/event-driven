package com.edstem.eventDriven.event;

public class ProductOutOfStockEvent {
    private final Long userId;
    private final String productName;

    public ProductOutOfStockEvent(Long userId, String productName) {
        this.userId = userId;
        this.productName = productName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getProductName() {
        return productName;
    }
}

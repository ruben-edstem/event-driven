package com.edstem.eventDriven.listener;

import com.edstem.eventDriven.event.UserRegisteredEvent;
import com.edstem.eventDriven.event.OrderPlacedEvent;
import com.edstem.eventDriven.event.ProductOutOfStockEvent;
import com.edstem.eventDriven.model.Notification;
import com.edstem.eventDriven.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationRepository notificationRepository;

    @Async
    @EventListener
    public void handleUserRegistered(UserRegisteredEvent event) {
        String message = "Welcome " + event.getUserName() + "! Thanks for registering.";
        Notification notification = new Notification(event.getUserId(), "UserRegistered", message);
        notificationRepository.save(notification);
    }

    @Async
    @EventListener
    public void handleOrderPlaced(OrderPlacedEvent event) {
        String message = "Your order with ID " + event.getOrderId() + " has been placed.";
        Notification notification = new Notification(event.getUserId(), "OrderPlaced", message);
        notificationRepository.save(notification);
    }

    @Async
    @EventListener
    public void handleProductOutOfStock(ProductOutOfStockEvent event) {
        String message = "Product out of stock: " + event.getProductName();
        Notification notification = new Notification(0L, "ProductOutOfStock", message);
        notificationRepository.save(notification);
    }
}


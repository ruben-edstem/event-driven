package com.edstem.eventDriven.controller;

import com.edstem.eventDriven.event.OrderPlacedEvent;
import com.edstem.eventDriven.event.ProductOutOfStockEvent;
import com.edstem.eventDriven.event.UserRegisteredEvent;
import com.edstem.eventDriven.model.Notification;
import com.edstem.eventDriven.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/{userId}")
    public List<Notification> getNotificationsByUser(@PathVariable Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    @PostMapping("/test")
    public String triggerTestEvents() {
        eventPublisher.publishEvent(new UserRegisteredEvent(1L, "Ruben"));
        eventPublisher.publishEvent(new OrderPlacedEvent(1L, 101L));
        eventPublisher.publishEvent(new ProductOutOfStockEvent(0L, "Bottle"));
        return "Events triggered!";
    }
}

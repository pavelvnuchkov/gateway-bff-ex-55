package com.example.orderAPI.controller;

import com.example.orderAPI.services.ServicesOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.pavel.Order;

@RestController
public class ControllerOrder {
    private final ServicesOrder servicesOrder;

    public ControllerOrder(ServicesOrder servicesOrder) {
        this.servicesOrder = servicesOrder;
    }

    @GetMapping("/api/orders/by-user/{user}")
    public ResponseEntity<Order> getOrder(@PathVariable String user) {
        return servicesOrder.getOrder(user);
    }
}

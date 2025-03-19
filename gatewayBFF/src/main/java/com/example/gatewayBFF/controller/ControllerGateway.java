package com.example.gatewayBFF.controller;

import com.example.gatewayBFF.model.UserOrderDto;
import com.example.gatewayBFF.service.ServiceGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerGateway {

    private final ServiceGateway serviceGateway;

    public ControllerGateway(ServiceGateway serviceGateway) {
        this.serviceGateway = serviceGateway;
    }

    @GetMapping("/api/site-bff/user/{userId}")
    public ResponseEntity<UserOrderDto> getInfoOrderUser(@PathVariable String userId) {
        return serviceGateway.getInfoOrder(userId);
    }
}

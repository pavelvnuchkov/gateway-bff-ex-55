package com.example.orderAPI.services;

import com.example.orderAPI.repository.RepositoryOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.pavel.Order;

import java.util.Optional;

@Service
public class ServicesOrder {
    private final RepositoryOrder repositoryOrder;

    public ServicesOrder(RepositoryOrder repositoryOrder) {
        this.repositoryOrder = repositoryOrder;
    }

    public ResponseEntity<Order> getOrder(String userId) {
        Optional<Order> optionalOrder = repositoryOrder.getOrder(userId);
        return optionalOrder.map(order -> new ResponseEntity<>(order, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new Order(), HttpStatus.BAD_REQUEST));
    }
}

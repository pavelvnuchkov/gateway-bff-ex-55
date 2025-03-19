package com.example.orderAPI.repository;

import org.springframework.stereotype.Repository;
import ru.pavel.Order;
import ru.pavel.Product;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class RepositoryOrder {
    private final Map<String, Order> orderList;

    public RepositoryOrder() {
        this.orderList = new ConcurrentHashMap<>();
        Product product = new Product("Хлеб", 55);
        Product product1 = new Product("Молоко", 88);
        Product product2 = new Product("Колбаса", 250);
        Product product3 = new Product("Гречка", 100);
        Product product4 = new Product("Картошка", 77);
        Order order = new Order();
        order.addProductList(product);
        order.addProductList(product1);
        order.addProductList(product2);
        order.setCurrency("RUR");
        order.setUserId("1");
        order.setId("2");
        Order order2 = new Order();
        order2.addProductList(product3);
        order2.addProductList(product4);
        order2.setCurrency("RUR");
        order2.setUserId("2");
        order2.setId("1");
        this.orderList.put(order2.getUserId(), order2);
        this.orderList.put(order.getUserId(), order);
    }

    public Optional<Order> getOrder(String userId) {
        return Optional.ofNullable(orderList.get(userId));
    }
}

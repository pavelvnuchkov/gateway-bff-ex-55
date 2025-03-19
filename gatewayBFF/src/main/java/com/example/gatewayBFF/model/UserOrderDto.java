package com.example.gatewayBFF.model;

import ru.pavel.Product;
import ru.pavel.lib.User;

import java.util.List;

public class UserOrderDto {

    private String orderId;
    private User user;
    private int orderAmount;
    private String orderCurrency;
    private List<Product> productList;

    public UserOrderDto() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "UserOrderDto{" +
                "orderId='" + orderId + '\'' +
                ", user=" + user +
                ", orderAmount=" + orderAmount +
                ", orderCurrency='" + orderCurrency + '\'' +
                ", productList=" + productList +
                '}';
    }
}

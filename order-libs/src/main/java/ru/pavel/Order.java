package ru.pavel;

import java.util.ArrayList;
import java.util.List;


public class Order {

    private String id;
    private String userId;
    private int amount;
    private String currency;
    private List<Product> productList;

    public Order() {
        this.productList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public boolean addProductList(Product product) {
        this.amount = this.amount + product.getPrice();
        return productList.add(product);
    }
}

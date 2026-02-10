package com.example.Ecommerce.model;

import lombok.Data;

import java.util.List;
@Data
public class Carts {
    private int id;
    private int userId;
    private List<CartProduct> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }
}

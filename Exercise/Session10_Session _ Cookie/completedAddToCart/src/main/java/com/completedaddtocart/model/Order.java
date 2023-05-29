package com.completedaddtocart.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<Product, Integer> cart = new HashMap<>();
    private int total;
    private LocalDate localDate;

    public Order() {
    }

    public Order(Map<Product, Integer> cart, int total) {
        this.cart = cart;
        this.total = total;
        this.localDate = LocalDate.now();
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }


}

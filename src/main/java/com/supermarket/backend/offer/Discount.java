package com.supermarket.backend.offer;

public class Discount {

    public final String description;
    public final double discountAmount;

    public Discount(String description, double discountAmount) {
        this.description = description;
        this.discountAmount = discountAmount;
    }

}

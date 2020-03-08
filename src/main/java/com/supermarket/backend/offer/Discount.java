package com.supermarket.backend.offer;

public class Discount {
    private final String description;
    private final double discountAmount;

    public Discount(String description, double discountAmount) {
        this.description = description;
        this.discountAmount = discountAmount;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

}

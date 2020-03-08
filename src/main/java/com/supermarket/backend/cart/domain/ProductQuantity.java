package com.supermarket.backend.cart.domain;

import com.supermarket.backend.catalog.Product;

public class ProductQuantity {
    private final Product product;
    private double quantity;

    public ProductQuantity(Product product, double weight) {
        this.product = product;
        this.quantity = weight;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

}

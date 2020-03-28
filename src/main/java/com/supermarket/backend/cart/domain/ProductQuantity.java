package com.supermarket.backend.cart.domain;

import com.supermarket.backend.catalog.Product;

public class ProductQuantity {
    public final Product product;
    public double quantity;

    public ProductQuantity(Product product, double weight) {
        this.product = product;
        this.quantity = weight;
    }

}

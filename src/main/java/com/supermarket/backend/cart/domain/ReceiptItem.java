package com.supermarket.backend.cart.domain;

import com.supermarket.backend.catalog.domain.Product;

import java.util.Objects;

public class ReceiptItem {
    public final Product product;
    public final double price;
    public final double quantity;

    ReceiptItem(Product p, double quantity, double price) {
        this.product = p;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptItem that = (ReceiptItem) o;
        return Double.compare(that.price, price) == 0 &&
                Double.compare(that.quantity, quantity) == 0 &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, price, quantity);
    }

}

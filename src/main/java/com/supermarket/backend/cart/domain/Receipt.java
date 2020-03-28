package com.supermarket.backend.cart.domain;

import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.offer.Discount;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    public List<ReceiptItem> items = new ArrayList<>();
    public List<Discount> discounts = new ArrayList<>();

    public Double getTotalPrice() {
        double total = 0.0;
        for (ReceiptItem item : this.items) {
            total += item.price * item.quantity;
        }
        for (Discount discount : this.discounts) {
            total -= discount.discountAmount;
        }
        return total;
    }

    public void addProduct(Product p, double quantity, double price) {
        this.items.add(new ReceiptItem(p, quantity, price));
    }

}

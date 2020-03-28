package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.ProductQuantity;
import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.pricing.PriceList;

import java.util.Locale;

public enum SpecialOfferType implements ISpecialOfferType {
    Percent {
        @Override
        public void addDiscountToReceipt(Receipt receipt, Bundle bundle, double fullSets, PriceList priceList) {
            for (ProductQuantity pq : bundle.getProductsArray()) {
                Product product = pq.product;
                double totalPrice = priceList.getProductPrice(product) * fullSets * pq.quantity;
                double discountAmount = totalPrice * bundle.getValue() / 100.0;
                String description = String.format(Locale.UK, "%.0f", bundle.getValue()) + "% off" +
                        " (" + product.name + ")";
                receipt.discounts.add(new Discount(description, discountAmount));
            }
        }

    }, FixAmount {
        @Override
        public void addDiscountToReceipt(Receipt receipt, Bundle bundle, double fullSets, PriceList priceList) {
            double totalPrice = 0;
            StringBuilder productNames = new StringBuilder();
            for (ProductQuantity pq : bundle.getProductsArray()) {
                totalPrice += priceList.getProductPrice(pq.product) * fullSets * pq.quantity;
                productNames.append(pq.product.name).append("+");
            }
            double discountAmount = totalPrice - bundle.getValue() * fullSets;
            String description = "bundle for " + String.format(Locale.UK, "%.2f", bundle.getValue()) +
                    " (" + productNames.substring(0, productNames.length() - 1) + ")";
            receipt.discounts.add(new Discount(description, discountAmount));
        }
    };
}

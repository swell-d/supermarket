package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.ProductQuantity;
import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

import java.util.Locale;

public enum SpecialOfferType implements ISpecialOfferType {
    Percent {
        @Override
        public void addDiscountToReceipt(Receipt receipt, Bundle bundle, double fullSets, Catalog catalog) {
            for (ProductQuantity pq : bundle.productsSet) {
                Product product = pq.product;
                double totalPrice = catalog.getBaseProductPrice(product) * fullSets * pq.quantity;
                double discountAmount = totalPrice * bundle.value / 100.0;
                String description = String.format(Locale.UK, "%.0f", bundle.value) + "% off" +
                        " (" + product.importer.name() + ")";
                receipt.discounts.add(new Discount(description, discountAmount));
            }
        }

    }, FixAmount {
        @Override
        public void addDiscountToReceipt(Receipt receipt, Bundle bundle, double fullSets, Catalog catalog) {
            double totalPrice = 0;
            StringBuilder productNames = new StringBuilder();
            for (ProductQuantity pq : bundle.productsSet) {
                totalPrice += catalog.getBaseProductPrice(pq.product) * fullSets * pq.quantity;
                productNames.append(pq.product.importer.name()).append("+");
            }
            double discountAmount = totalPrice - bundle.value * fullSets;
            String description = "bundle for " + String.format(Locale.UK, "%.2f", bundle.value) +
                    " (" + productNames.substring(0, productNames.length() - 1) + ")";
            receipt.discounts.add(new Discount(description, discountAmount));
        }
    };
}

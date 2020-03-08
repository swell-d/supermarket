package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.ProductQuantity;
import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.catalog.Product;

import java.util.Locale;

public enum SpecialOfferTypeV2 implements ISpecialOfferTypeV2 {
    Percent {
        @Override
        public void addDiscountToReceipt(double totalPrice, Receipt receipt, Bundle bundle, double fullSets,
                                         ProductQuantity pq, Product product) {
            double discountAmount = totalPrice * bundle.getValue() / 100.0;
            String description = String.format(Locale.UK, "%.0f", bundle.getValue()) + "% off";
            receipt.addDiscount(new Discount(product, description, discountAmount));
        }
    }, FixAmount {
        @Override
        public void addDiscountToReceipt(double totalPrice, Receipt receipt, Bundle bundle, double fullSets,
                                         ProductQuantity pq, Product product) {
            double discountAmount = totalPrice - bundle.getValue() * fullSets;
            String description = String.format(Locale.UK, "%.0f", pq.getQuantity()) + " for " +
                    String.format(Locale.UK, "%.2f", bundle.getValue());
            receipt.addDiscount(new Discount(product, description, discountAmount));
        }
    };
}

package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.ProductQuantity;
import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.catalog.Product;

public interface ISpecialOfferTypeV2 {
    void addDiscountToReceipt(double totalPrice, Receipt receipt, Bundle bundle, double fullSets,
                              ProductQuantity pq, Product product);
}

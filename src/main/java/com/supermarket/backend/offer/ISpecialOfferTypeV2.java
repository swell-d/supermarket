package com.supermarket.backend.offer;

import com.supermarket.backend.product.Product;
import com.supermarket.backend.product.ProductQuantity;
import com.supermarket.backend.cart.Receipt;

public interface ISpecialOfferTypeV2 {
    void addDiscountToReceipt(double totalPrice, Receipt receipt, Bundle bundle, double fullSets,
                              ProductQuantity pq, Product product);
}

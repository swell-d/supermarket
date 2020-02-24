package com.supermarket.backend.model;

public interface ISpecialOfferTypeV2 {
    void addDiscountToReceipt(double totalPrice, Receipt receipt, Bundle bundle, double fullSets,
                              ProductQuantity pq, Product product);
}

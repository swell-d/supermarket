package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.catalog.domain.Catalog;

public interface ISpecialOfferType {

    void addDiscountToReceipt(Receipt receipt, Bundle bundle, double fullSets, Catalog catalog);

}

package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.ProductQuantity;
import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.catalog.domain.Catalog;

import java.util.ArrayList;

public class Bundle {
    public final ArrayList<ProductQuantity> productsSet;
    public final double value;
    public final SpecialOfferType specialOfferType;

    public Bundle(ArrayList<ProductQuantity> productsSet, double value, SpecialOfferType specialOfferType) {
        this.productsSet = productsSet;
        this.value = value;
        this.specialOfferType = specialOfferType;
    }

    public void addDiscountToReceipt(Receipt receipt, Bundle bundle, double fullSets, Catalog catalog) {
        specialOfferType.addDiscountToReceipt(receipt, bundle, fullSets, catalog);
    }

}

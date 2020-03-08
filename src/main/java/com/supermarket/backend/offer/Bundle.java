package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.ProductQuantity;

import java.util.ArrayList;

public class Bundle {
    private final ArrayList<ProductQuantity> productsSet;
    private final double value;
    private final SpecialOfferType specialOfferType;

    public Bundle(ArrayList<ProductQuantity> productsSet, double value, SpecialOfferType specialOfferType) {
        this.productsSet = productsSet;
        this.value = value;
        this.specialOfferType = specialOfferType;
    }

    public ArrayList<ProductQuantity> getProductsArray() {
        return productsSet;
    }

    public double getValue() {
        return value;
    }

    public SpecialOfferType getSpecialOfferType() {
        return specialOfferType;
    }
}

package com.supermarket.backend.offer;

import com.supermarket.backend.product.ProductQuantity;

import java.util.ArrayList;

public class Bundle {
    private final ArrayList<ProductQuantity> productsSet;
    private final double value;
    private final SpecialOfferTypeV2 specialOfferType;

    public Bundle(ArrayList<ProductQuantity> productsSet, double value, SpecialOfferTypeV2 specialOfferType) {
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

    public SpecialOfferTypeV2 getSpecialOfferType() {
        return specialOfferType;
    }
}

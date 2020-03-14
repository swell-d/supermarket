package com.supermarket.backend.config;

import com.supermarket.backend.cart.domain.ProductQuantity;
import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.offer.Bundle;
import com.supermarket.backend.offer.SpecialOfferType;

import java.util.ArrayList;

public class MockBundles {

    public static Bundle tenPercentBundle(Catalog catalog) {
        ArrayList<ProductQuantity> tenPercentBundle = new ArrayList<>();
        tenPercentBundle.add(new ProductQuantity(catalog.getProductByName("Tomatoes"), 1.5));
        return new Bundle(tenPercentBundle, 10, SpecialOfferType.Percent);
    }

    public static Bundle fixPriceBundle(Catalog catalog) {
        ArrayList<ProductQuantity> fixPriceBundle = new ArrayList<>();
        fixPriceBundle.add(new ProductQuantity(catalog.getProductByName("Phone"), 1));
        fixPriceBundle.add(new ProductQuantity(catalog.getProductByName("Bag"), 1));
        return new Bundle(fixPriceBundle, 899.90, SpecialOfferType.FixAmount);
    }

}

package com.supermarket.backend.mock;

import com.supermarket.backend.cart.domain.ProductQuantity;
import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.offer.Bundle;
import com.supermarket.backend.offer.SpecialOfferType;

import java.util.ArrayList;

public class MockBundlesFactory {

    public static Bundle createTenPercentBundle(Catalog catalog) {
        ArrayList<ProductQuantity> tenPercentBundle = new ArrayList<>();
        tenPercentBundle.add(new ProductQuantity(catalog.byArticle("Tomatoes"), 1.5));
        return new Bundle(tenPercentBundle, 10, SpecialOfferType.Percent);
    }

    public static Bundle createFixPriceBundle(Catalog catalog) {
        ArrayList<ProductQuantity> fixPriceBundle = new ArrayList<>();
        fixPriceBundle.add(new ProductQuantity(catalog.byArticle("Phone"), 1));
        fixPriceBundle.add(new ProductQuantity(catalog.byArticle("Bag"), 1));
        return new Bundle(fixPriceBundle, 899.90, SpecialOfferType.FixAmount);
    }

}

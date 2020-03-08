package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.ProductQuantity;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Product;

import java.util.ArrayList;

public enum SpecialOfferType implements ISpecialOfferType {
    ThreeForTwo {
        @Override
        public void addSpecialOffer(Product product, double argument, ShoppingCart shoppingCart) {
            ArrayList<ProductQuantity> productsArray = new ArrayList<>();
            productsArray.add(new ProductQuantity(product, 3));
            shoppingCart.bundles.add(new Bundle(productsArray, argument, SpecialOfferTypeV2.FixAmount));
        }
    }, TenPercentDiscount {
        @Override
        public void addSpecialOffer(Product product, double argument, ShoppingCart shoppingCart) {
            ArrayList<ProductQuantity> productsArray = new ArrayList<>();
            productsArray.add(new ProductQuantity(product, 1));
            shoppingCart.bundles.add(new Bundle(productsArray, argument, SpecialOfferTypeV2.Percent));
        }
    }, TwoForAmount {
        @Override
        public void addSpecialOffer(Product product, double argument, ShoppingCart shoppingCart) {
            ArrayList<ProductQuantity> productsArray = new ArrayList<>();
            productsArray.add(new ProductQuantity(product, 2));
            shoppingCart.bundles.add(new Bundle(productsArray, argument, SpecialOfferTypeV2.FixAmount));
        }
    }, FiveForAmount {
        @Override
        public void addSpecialOffer(Product product, double argument, ShoppingCart shoppingCart) {
            ArrayList<ProductQuantity> productsArray = new ArrayList<>();
            productsArray.add(new ProductQuantity(product, 5));
            shoppingCart.bundles.add(new Bundle(productsArray, argument, SpecialOfferTypeV2.FixAmount));
        }
    }
}

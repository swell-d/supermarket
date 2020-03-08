package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;

public class AddProductAction {

    public static String addProduct(ShoppingCart cart, PriceList priceList,
                                    String productName, String productCount) {

        if (!AddProductAction.addProduct(cartRepository.getCart("user1"), priceList, productName, productCount))
            return productName + " not found.";
        return productName + " added.";


//        Product product = priceList.getCatalog().getProductByName(productName);
//        if (product == null) return false;
//        cart.addItemQuantity(product, Double.parseDouble(productCount));
//        return true;
    }

}

package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.report.ReceiptHTML;

public class CartActions {
    public static ShoppingCart createCart(Catalog catalog) {
        return new ShoppingCart(catalog);
    }

    public static boolean addProduct(ShoppingCart cart, Catalog catalog,
                                     String productName, String productCount) {
        Product product = catalog.getProductByName(productName);
        if (product == null) return false;
        cart.addItemQuantity(product, Double.parseDouble(productCount));
        return true;
    }

    public static String getHTMLReceipt(ShoppingCart cart) {
        return new ReceiptHTML().printReceipt(cart.checksOutArticlesFrom());
    }

}

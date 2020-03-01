package com.supermarket.backend.cart;

import com.supermarket.backend.catalogues.SupermarketCatalog;
import com.supermarket.backend.product.Product;
import com.supermarket.backend.report.ReceiptHTML;

public class CartActions {
    public static ShoppingCart createCart(SupermarketCatalog catalog) {
        return new ShoppingCart(catalog);
    }

    public static boolean addProduct(ShoppingCart cart, SupermarketCatalog catalog,
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

package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.CartRepository;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.report.ReceiptHTML;

public class GetReceiptAction {

    private CartRepository cartRepository;
    private Catalog catalog;

    public GetReceiptAction(CartRepository cartRepository, Catalog catalog) {
        this.cartRepository = cartRepository;
        this.catalog = catalog;
    }

    public String getReceipt() {
        ShoppingCart cart = cartRepository.getCart("user 1", catalog);
        return cart.export(new ReceiptHTML());
    }

}

package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.CartRepository;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;
import com.supermarket.backend.report.ReceiptHTML;

public class GetReceiptAction {

    private CartRepository cartRepository;
    private PriceList priceList;

    public GetReceiptAction(CartRepository cartRepository, PriceList priceList) {
        this.cartRepository = cartRepository;
        this.priceList = priceList;
    }

    public String getReceipt() {
        ShoppingCart cart = cartRepository.getCart("user 1", priceList);
        return cart.export(new ReceiptHTML());
    }

}

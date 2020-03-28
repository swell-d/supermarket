package com.supermarket.backend.cart.api.rest;

import com.supermarket.backend.cart.actions.GetReceiptAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetReceipt {

    private GetReceiptAction getReceiptAction;

    public GetReceipt(GetReceiptAction getReceiptAction) {
        this.getReceiptAction = getReceiptAction;
    }

    @GetMapping("/cart/receipt")
    public String receipt() {
        return getReceiptAction.getReceipt();
    }

}

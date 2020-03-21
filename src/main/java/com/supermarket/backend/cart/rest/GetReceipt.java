package com.supermarket.backend.cart.rest;

import com.supermarket.backend.cart.actions.GetReceiptAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetReceipt {

    private GetReceiptAction getReceiptAction;

    public GetReceipt(GetReceiptAction getReceiptAction) {
        this.getReceiptAction = getReceiptAction;
    }

    @GetMapping("/receipt")
    public String receipt() {
        return getReceiptAction.getReceipt();
    }

}

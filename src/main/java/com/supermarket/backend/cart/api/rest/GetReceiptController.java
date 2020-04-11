package com.supermarket.backend.cart.api.rest;

import com.supermarket.backend.cart.actions.GetReceiptAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetReceiptController {

    private GetReceiptAction getReceiptAction;

    public GetReceiptController(GetReceiptAction getReceiptAction) {
        this.getReceiptAction = getReceiptAction;
    }

    @GetMapping(path = "/cart")
    public String receipt() {
        return getReceiptAction.getReceipt();
    }

}

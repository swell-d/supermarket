package com.supermarket.backend.report;

import com.supermarket.backend.cart.Receipt;

public interface ReceiptOutput {
    public String printReceipt(Receipt receipt);
}

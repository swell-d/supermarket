package com.supermarket.backend.report;

import com.supermarket.backend.cart.domain.Receipt;

public interface Report {

    String printReceipt(Receipt receipt);

}

package com.supermarket.backend.report;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.config.MockCartFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptPrinterTests {

    private final String LS = System.lineSeparator();

    @Test
    public void receiptPrinterTest() {
        ShoppingCart cart = MockCartFactory.createMockCart();
        String expected =
                "Tomatoes                          435.60" + LS +
                        "  99.00 * 4.400" + LS +
                        "Potatoes                          363.00" + LS +
                        "  66.00 * 5.500" + LS +
                        "Phone                             999.90" + LS +
                        "Bag                                27.00" + LS +
                        "  9.00 * 3" + LS +
                        "10% off (Tomatoes)                -43.56" + LS +
                        "bundle for 899.90 (Phone+Bag)    -109.00" + LS +
                        "" + LS +
                        "Total:                           1672.94" + LS;
        assertEquals(expected, new ReceiptPrinter(40).printReceipt(cart.getReceipt()));
    }

}

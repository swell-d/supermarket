package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;
import com.supermarket.backend.mock.MockBundlesFactory;
import com.supermarket.backend.mock.MockCatalogFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BundleTests {

    @Test
    public void percentBundleTest() {
        Catalog catalog = new MockCatalogFactory().createMockCatalog();
        Product tomatoes = catalog.getProductByName("Tomatoes");
        ShoppingCart cart = new ShoppingCart(catalog);
        cart.addBundle(MockBundlesFactory.createTenPercentBundle(catalog));
        cart.addItemQuantity(tomatoes, 0.5);
        checkReceipt(cart.getReceipt(), 1, catalog.getBaseProductPrice(tomatoes) * 0.5);
        cart.addItemQuantity(tomatoes, 0.5);
        checkReceipt(cart.getReceipt(), 1, catalog.getBaseProductPrice(tomatoes) * 1);
        cart.addItemQuantity(tomatoes, 0.5);
        checkReceipt(cart.getReceipt(), 1, catalog.getBaseProductPrice(tomatoes) * 1.5 * 0.9);
        cart.addItemQuantity(tomatoes, 0.5);
        checkReceipt(cart.getReceipt(), 1, catalog.getBaseProductPrice(tomatoes) * 2.0 * 0.9);
        cart.addItemQuantity(tomatoes, 0.5);
        checkReceipt(cart.getReceipt(), 1, catalog.getBaseProductPrice(tomatoes) * 2.5 * 0.9);
    }

    @Test
    public void fixAmountBundleTest() {
        Catalog catalog = new MockCatalogFactory().createMockCatalog();
        Product phone = catalog.getProductByName("Phone");
        Product bag = catalog.getProductByName("Bag");
        ShoppingCart cart = new ShoppingCart(catalog);
        cart.addBundle(MockBundlesFactory.createFixPriceBundle(catalog));
        cart.addItemQuantity(phone, 1);
        checkReceipt(cart.getReceipt(), 1, catalog.getBaseProductPrice(phone) * 1);
        cart.addItemQuantity(phone, 1);
        checkReceipt(cart.getReceipt(), 1, catalog.getBaseProductPrice(phone) * 2);
        cart.addItemQuantity(bag, 1);
        checkReceipt(cart.getReceipt(), 2, 899.90 + catalog.getBaseProductPrice(phone));
        cart.addItemQuantity(bag, 1);
        checkReceipt(cart.getReceipt(), 2, 899.90 * 2);
        cart.addItemQuantity(bag, 1);
        checkReceipt(cart.getReceipt(), 2, 899.90 * 2 + catalog.getBaseProductPrice(bag));
    }


    private void checkReceipt(Receipt receipt, int items, double sum) {
        assertEquals(items, receipt.items.size());
        assertEquals(sum, receipt.getTotalPrice(), 0.01);
    }

}

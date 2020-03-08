package com.supermarket.backend.pricing.db;

import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.catalog.ProductUnit;
import com.supermarket.backend.catalog.db.array.ArrayCatalog;
import com.supermarket.backend.pricing.PriceList;
import com.supermarket.backend.pricing.db.hashmap.HashMapPriceList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapPriceListTests {

    @Test
    public void createPriceListTest() {
        PriceList priceList = new HashMapPriceList(new ArrayCatalog());
        assertNotNull(priceList);
        assertEquals(0, priceList.getPriceList().size());
    }

    @Test
    public void addProductTest() {
        PriceList priceList = new HashMapPriceList(new ArrayCatalog());
        Product product1 = new Product("test sku 1", "test name 1", ProductUnit.Each);
        Product product2 = new Product("test sku 2", "test name 2", ProductUnit.Kilo);

        assertTrue(priceList.addProduct(product1, 123));
        assertEquals(1, priceList.getPriceList().size());
        assertEquals(123, priceList.getPriceList().get(product1));
        assertEquals(123, priceList.getProductPrice(product1));

        assertTrue(priceList.addProduct(product2, 234));
        assertEquals(2, priceList.getPriceList().size());
        assertEquals(123, priceList.getProductPrice(product1));
        assertEquals(234, priceList.getProductPrice(product2));
    }

    @Test
    public void deleteProductTest() {
        PriceList priceList = new HashMapPriceList(new ArrayCatalog());
        Product product1 = new Product("test sku 1", "test name 1", ProductUnit.Each);
        Product product2 = new Product("test sku 2", "test name 2", ProductUnit.Kilo);

        priceList.addProduct(product1, 123);
        assertEquals(1, priceList.getPriceList().size());
        priceList.addProduct(product2, 234);
        assertEquals(2, priceList.getPriceList().size());

        assertTrue(priceList.deleteProduct(product2));
        assertEquals(1, priceList.getPriceList().size());
        assertFalse(priceList.deleteProduct(product2));

        assertTrue(priceList.deleteProduct(product1));
        assertEquals(0, priceList.getPriceList().size());
        assertFalse(priceList.deleteProduct(product1));
    }

}

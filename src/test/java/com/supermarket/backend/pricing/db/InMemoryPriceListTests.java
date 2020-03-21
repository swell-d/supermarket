package com.supermarket.backend.pricing.db;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.catalog.ProductUnit;
import com.supermarket.backend.catalog.db.memory.InMemoryCatalog;
import com.supermarket.backend.pricing.PriceList;
import com.supermarket.backend.pricing.db.memory.InMemoryPriceList;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InMemoryPriceListTests {

    @Test
    public void createPriceListTest() {
        PriceList priceList = new InMemoryPriceList(null);
        assertNotNull(priceList);
        assertEquals(0, priceList.getPriceList().size());
    }

    @Test
    public void addProductTest() {
        Product product1 = new Product("test sku 1", "test name 1", ProductUnit.Each);
        Product product2 = new Product("test sku 2", "test name 2", ProductUnit.Kilo);
        Catalog catalog = new InMemoryCatalog();
        catalog.addProduct(product1);
        catalog.addProduct(product2);
        PriceList priceList = new InMemoryPriceList(catalog);
        priceList.addPrice(product1, 123);
        assertEquals(1, priceList.getPriceList().size());
        assertEquals(123, priceList.getPriceList().get(product1));
        assertEquals(123, priceList.getProductPrice(product1));
        priceList.addPrice(product2, 234);
        assertEquals(2, priceList.getPriceList().size());
        assertEquals(123, priceList.getProductPrice(product1));
        assertEquals(234, priceList.getProductPrice(product2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductTwiceTest() {
        Product product1 = new Product("test sku 1", "test name 1", ProductUnit.Each);
        Catalog catalog = new InMemoryCatalog();
        catalog.addProduct(product1);
        PriceList priceList = new InMemoryPriceList(catalog);
        priceList.addPrice(product1, 123);
        priceList.addPrice(product1, 123);
    }

    @Test
    public void deleteProductTest() {
        Product product1 = new Product("test sku 1", "test name 1", ProductUnit.Each);
        Product product2 = new Product("test sku 2", "test name 2", ProductUnit.Kilo);
        Catalog catalog = new InMemoryCatalog();
        catalog.addProduct(product1);
        catalog.addProduct(product2);
        PriceList priceList = new InMemoryPriceList(catalog);
        priceList.addPrice(product1, 123);
        priceList.addPrice(product2, 234);
        priceList.deleteProduct(product2);
        assertEquals(1, priceList.getPriceList().size());
        priceList.deleteProduct(product1);
        assertEquals(0, priceList.getPriceList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteProductTwiceTest() {
        Product product1 = new Product("test sku 1", "test name 1", ProductUnit.Each);
        Catalog catalog = new InMemoryCatalog();
        catalog.addProduct(product1);
        PriceList priceList = new InMemoryPriceList(catalog);
        priceList.addPrice(product1, 123);
        priceList.deleteProduct(product1);
        priceList.deleteProduct(product1);
    }

}

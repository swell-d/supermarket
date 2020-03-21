package com.supermarket.backend.catalog.db;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.catalog.ProductUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatalogTests {

    public static void createCatalog(Catalog catalog) {
        assertNotNull(catalog);
        assertEquals(0, catalog.getCatalog().size());
    }

    public static void addProduct(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", ProductUnit.Each);
        Product product2 = new Product("test article 2", "test name 2", ProductUnit.Kilo);
        catalog.addProduct(product1);
        assertEquals(1, catalog.getCatalog().size());
        assertEquals(product1, catalog.getCatalog().get(0));
        catalog.addProduct(product2);
        assertEquals(2, catalog.getCatalog().size());
    }

    public static void addProductTwice(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", ProductUnit.Each);
        catalog.addProduct(product1);
        catalog.addProduct(product1);
    }

    public static void deleteProduct(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", ProductUnit.Each);
        Product product2 = new Product("test article 2", "test name 2", ProductUnit.Kilo);
        catalog.addProduct(product1);
        catalog.addProduct(product2);
        catalog.deleteProduct(product1);
        assertEquals(1, catalog.getCatalog().size());
        catalog.deleteProduct(product2);
        assertEquals(0, catalog.getCatalog().size());
    }

    public static void deleteProductTwice(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", ProductUnit.Each);
        catalog.addProduct(product1);
        catalog.deleteProduct(product1);
        catalog.deleteProduct(product1);
    }

    public static void getProductByName(Catalog catalog) {
        Product product1 = new Product("product1", ProductUnit.Each);
        catalog.addProduct(product1);
        assertEquals(product1, catalog.getProductByName("product1"));
    }

    public static void checkExistsProduct(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", ProductUnit.Each);
        Product product2 = new Product("test article 1", "test name 2", ProductUnit.Kilo);
        catalog.addProduct(product1);
        catalog.addProduct(product2);
    }
}

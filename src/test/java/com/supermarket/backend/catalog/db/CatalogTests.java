package com.supermarket.backend.catalog.db;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.catalog.ProductUnit;

import static org.junit.Assert.*;

public class CatalogTests {

    public static void createCatalogTest(Catalog catalog) {
        assertNotNull(catalog);
        assertEquals(0, catalog.getCatalog().size());
    }

    public static void addProductTest(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", ProductUnit.Each);
        Product product2 = new Product("test article 2", "test name 2", ProductUnit.Kilo);

        assertTrue(catalog.addProduct(product1));
        assertEquals(1, catalog.getCatalog().size());
        assertEquals(product1, catalog.getCatalog().get(0));

        assertFalse(catalog.addProduct(product1));
        assertEquals(1, catalog.getCatalog().size());

        assertTrue(catalog.addProduct(product2));
        assertEquals(2, catalog.getCatalog().size());

        assertFalse(catalog.addProduct(product2));
        assertEquals(2, catalog.getCatalog().size());
    }

    public static void deleteProductTest(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", ProductUnit.Each);
        Product product2 = new Product("test article 2", "test name 2", ProductUnit.Kilo);

        assertTrue(catalog.addProduct(product1));
        assertEquals(1, catalog.getCatalog().size());

        assertTrue(catalog.addProduct(product2));
        assertEquals(2, catalog.getCatalog().size());

        assertTrue(catalog.deleteProduct(product1));
        assertEquals(1, catalog.getCatalog().size());

        assertFalse(catalog.deleteProduct(product1));
        assertEquals(1, catalog.getCatalog().size());

        assertTrue(catalog.deleteProduct(product2));
        assertEquals(0, catalog.getCatalog().size());

        assertFalse(catalog.deleteProduct(product2));
        assertEquals(0, catalog.getCatalog().size());
    }

    public static void getProductByNameTest(Catalog catalog) {
        Product product1 = new Product("product1", ProductUnit.Each);
        catalog.addProduct(product1);
        assertEquals(product1, catalog.getProductByName("product1"));
    }

    public static void checkExistsProductTest(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", ProductUnit.Each);
        Product product2 = new Product("test article 1", "test name 2", ProductUnit.Kilo);
        assertTrue(catalog.addProduct(product1));
        assertFalse(catalog.addProduct(product2));
    }
}

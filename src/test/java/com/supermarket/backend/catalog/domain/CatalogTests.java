package com.supermarket.backend.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatalogTests {

    public static void createCatalog(Catalog catalog) {
        assertNotNull(catalog);
        assertEquals(0, catalog.getProducts().size());
    }

    public static void addProduct(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", MeasurementUnit.Each);
        Product product2 = new Product("test article 2", "test name 2", MeasurementUnit.Kilo);
        catalog.add(product1);
        assertEquals(1, catalog.getProducts().size());
        assertEquals(product1, catalog.getProducts().get(0));
        catalog.add(product2);
        assertEquals(2, catalog.getProducts().size());
    }

    public static void addProductTwice(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", MeasurementUnit.Each);
        catalog.add(product1);
        catalog.add(product1);
    }

    public static void deleteProduct(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", MeasurementUnit.Each);
        Product product2 = new Product("test article 2", "test name 2", MeasurementUnit.Kilo);
        catalog.add(product1);
        catalog.add(product2);
        catalog.deleteProduct(product1);
        assertEquals(1, catalog.getProducts().size());
        catalog.deleteProduct(product2);
        assertEquals(0, catalog.getProducts().size());
    }

    public static void deleteProductTwice(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", MeasurementUnit.Each);
        catalog.add(product1);
        catalog.deleteProduct(product1);
        catalog.deleteProduct(product1);
    }

    public static void getProductByName(Catalog catalog) {
        Product product1 = new Product("product1", "product1", MeasurementUnit.Each);
        catalog.add(product1);
        assertEquals(product1, catalog.getProductByName("product1"));
    }

    public static void checkExistsProduct(Catalog catalog) {
        Product product1 = new Product("test article 1", "test name 1", MeasurementUnit.Each);
        Product product2 = new Product("test article 1", "test name 2", MeasurementUnit.Kilo);
        catalog.add(product1);
        catalog.add(product2);
    }
}

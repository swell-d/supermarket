package com.supermarket.backend.catalog.domain;

import com.supermarket.backend.catalog.actions.StabImporter;
import com.supermarket.backend.catalog.actions.StabImporterBuilder;

import static com.supermarket.backend.catalog.actions.StabImporterBuilder.importerBuilder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatalogTests {

    public static void createCatalog(Catalog catalog) {
        assertNotNull(catalog);
        assertEquals(0, catalog.getProducts().size());
    }

    public static void addProduct(Catalog catalog) {
        Product product1 = new Product(importerBuilder().create());
        Product product2 = new Product(importerBuilder().withArticle("another").create());
        catalog.add(product1);
        assertEquals(1, catalog.getProducts().size());
        assertEquals(product1, catalog.getProducts().get(0));
        catalog.add(product2);
        assertEquals(2, catalog.getProducts().size());
    }

    public static void addProductTwice(Catalog catalog) {
        Product product1 = new Product(importerBuilder().create());
        catalog.add(product1);
        catalog.add(product1);
    }

    public static void deleteProduct(Catalog catalog) {
        Product product1 = new Product(importerBuilder().withArticle("art1").create());
        Product product2 = new Product(importerBuilder().withArticle("art2").create());
        catalog.add(product1);
        catalog.add(product2);
        catalog.deleteProduct(product1);
        assertEquals(1, catalog.getProducts().size());
        catalog.deleteProduct(product2);
        assertEquals(0, catalog.getProducts().size());
    }

    public static void deleteProductTwice(Catalog catalog) {
        Product product1 = new Product(importerBuilder().create());
        catalog.add(product1);
        catalog.deleteProduct(product1);
        catalog.deleteProduct(product1);
    }

    public static void getProductByName(Catalog catalog) {
        Product product1 = new Product(importerBuilder().withName("product1").create());
        catalog.add(product1);
        assertEquals(product1, catalog.getProductByName("product1"));
    }

    public static void checkExistsProduct(Catalog catalog) {
        Product product1 = new Product(importerBuilder().withName("test name 1").create());
        Product product2 = new Product(importerBuilder().withName("test name 2").create());
        catalog.add(product1);
        catalog.add(product2);
    }
}

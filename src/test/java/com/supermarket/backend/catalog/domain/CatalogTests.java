package com.supermarket.backend.catalog.domain;

import com.supermarket.backend.catalog.actions.StabImporter;

import static com.supermarket.backend.catalog.actions.StabImporterBuilder.importerBuilder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatalogTests {

    public static void createCatalog(Catalog catalog) {
        assertNotNull(catalog);
        assertEquals(0, catalog.getProducts().size());
    }

    public static void addProduct(Catalog catalog) {
        StabImporter importer = importerBuilder().create();
        catalog.add(importer);
        assertEquals(1, catalog.getProducts().size());
        assertEquals(new Product(importer), catalog.getProducts().get(0));
        catalog.add(importerBuilder().withArticle("another").create());
        assertEquals(2, catalog.getProducts().size());
    }

    public static void addProductTwiceShouldFail(Catalog catalog) {
        catalog.add(importerBuilder().create());
        catalog.add(importerBuilder().create());
    }

    public static void deleteProduct(Catalog catalog) {
        StabImporter art1 = importerBuilder().withArticle("art1").create();
        StabImporter art2 = importerBuilder().withArticle("art2").create();
        catalog.add(art1);
        catalog.add(art2);
        catalog.deleteProduct(new Product(art1));
        assertEquals(1, catalog.getProducts().size());
        catalog.deleteProduct(new Product(art2));
        assertEquals(0, catalog.getProducts().size());
    }

    public static void deleteProductTwice(Catalog catalog) {

        catalog.deleteProduct(new Product(importerBuilder().create()));
        catalog.deleteProduct(new Product(importerBuilder().create()));
    }

    public static void getProductByName(Catalog catalog) {
        StabImporter importer = importerBuilder().withName("product1").create();
        catalog.add(importer);
        assertEquals(new Product(importer), catalog.getProductByName("product1"));
    }

    public static void checkFailureOnSameArticle(Catalog catalog) {
        catalog.add(importerBuilder().withName("test name 1").create());
        catalog.add(importerBuilder().withName("test name 2").create());
    }
}

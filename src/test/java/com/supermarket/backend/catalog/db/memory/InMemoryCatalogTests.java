package com.supermarket.backend.catalog.db.memory;

import com.supermarket.backend.catalog.domain.CatalogTests;
import org.junit.Test;

public class InMemoryCatalogTests {

    @Test
    public void createCatalogTest() {
        CatalogTests.createCatalog(new InMemoryCatalog());
    }

    @Test
    public void addProductTest() {
        CatalogTests.addProduct(new InMemoryCatalog());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductTwiceTest() {
        CatalogTests.addProductTwice(new InMemoryCatalog());
    }

    @Test
    public void deleteProductTest() {
        CatalogTests.deleteProduct(new InMemoryCatalog());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteProductTwiceTest() {
        CatalogTests.deleteProductTwice(new InMemoryCatalog());
    }

    @Test
    public void getProductByNameTest() {
        CatalogTests.getProductByName(new InMemoryCatalog());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkExistsProductTest() {
        CatalogTests.checkExistsProduct(new InMemoryCatalog());
    }

}

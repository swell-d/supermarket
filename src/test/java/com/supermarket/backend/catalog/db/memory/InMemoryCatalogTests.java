package com.supermarket.backend.catalog.db.memory;

import com.supermarket.backend.catalog.domain.CatalogTests;
import org.junit.Test;

public class InMemoryCatalogTests {

    @Test
    public void createCatalogTest() {
        CatalogTests.createCatalog(new InMemoryCatalog(true));
    }

    @Test
    public void addProductTest() {
        CatalogTests.addProduct(new InMemoryCatalog(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductTwiceTest() {
        CatalogTests.addProductTwice(new InMemoryCatalog(true));
    }

    @Test
    public void deleteProductTest() {
        CatalogTests.deleteProduct(new InMemoryCatalog(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteProductTwiceTest() {
        CatalogTests.deleteProductTwice(new InMemoryCatalog(true));
    }

    @Test
    public void getProductByNameTest() {
        CatalogTests.getProductByName(new InMemoryCatalog(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkExistsProductTest() {
        CatalogTests.checkExistsProduct(new InMemoryCatalog(true));
    }

}

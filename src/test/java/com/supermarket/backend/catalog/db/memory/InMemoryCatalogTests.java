package com.supermarket.backend.catalog.db.memory;

import com.supermarket.backend.catalog.db.DBTests;
import com.supermarket.backend.catalog.domain.CatalogTests;
import org.junit.Test;

public class InMemoryCatalogTests implements DBTests {

    @Test
    public void createCatalog() {
        CatalogTests.createCatalog(new InMemoryCatalog(true));
    }

    @Test
    public void addProduct() {
        CatalogTests.addProduct(new InMemoryCatalog(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductTwiceShouldFail() {
        CatalogTests.addProductTwiceShouldFail(new InMemoryCatalog(true));
    }

    @Test
    public void deleteProduct() {
        CatalogTests.deleteProduct(new InMemoryCatalog(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteProductTwice() {
        CatalogTests.deleteProductTwice(new InMemoryCatalog(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkFailureOnSameArticle() {
        CatalogTests.checkFailureOnSameArticle(new InMemoryCatalog(true));
    }

}

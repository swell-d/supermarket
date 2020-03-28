package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.MeasurementUnit;
import com.supermarket.backend.catalog.domain.Product;
import com.supermarket.backend.mock.MockCatalogFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogActionsTests {

    @Test
    public void getCatalogTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        Catalog catalog = new CatalogActions(mockCatalog).getCatalog();
        assertEquals(mockCatalog, catalog);
    }

    @Test
    public void getProductByArticleTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        Product product = new CatalogActions(mockCatalog).getProductByArticle("Phone");
        assertEquals(mockCatalog.getProductByArticle("Phone"), product);
    }

    @Test
    public void addProductToCatalogTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        Product product = new Product("test article 1", "test name 1", MeasurementUnit.Each);
        new CatalogActions(mockCatalog).addProductToCatalog(product);
        assertEquals(mockCatalog.getProductByArticle("test article 1"), product);
    }

    @Test
    public void changeProductInCatalogTest() {
        // Todo how??
    }

    @Test
    public void deleteProductFromCatalogTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        new CatalogActions(mockCatalog).deleteProductFromCatalog(mockCatalog.getProductByArticle("Phone"));
        assertEquals(3, mockCatalog.getProducts().size());
    }

}

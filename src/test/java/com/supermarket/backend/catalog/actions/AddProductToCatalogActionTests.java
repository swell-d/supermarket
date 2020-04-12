package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.MeasurementUnit;
import com.supermarket.backend.catalog.domain.Product;
import com.supermarket.backend.mock.MockCatalogFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductToCatalogActionTests {

    @Test
    public void addProductToCatalogTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        Product product = new Product("test article 1", "test name 1", MeasurementUnit.Each);
        product.prices.put("Base", 0.0);
        new AddProductToCatalogAction(mockCatalog).addProductToCatalog(product);
        assertEquals(mockCatalog.getProductByArticle("test article 1"), product);
    }

    @Test(expected = IllegalStateException.class)
    public void addExistProductToCatalogTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        Product product = new Product("test article 1", "test name 1", MeasurementUnit.Each);
        product.prices.put("Base", 0.0);
        new AddProductToCatalogAction(mockCatalog).addProductToCatalog(product);
        new AddProductToCatalogAction(mockCatalog).addProductToCatalog(product);
    }

}

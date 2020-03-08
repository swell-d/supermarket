package com.supermarket.backend.model.fakecatalog;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.catalog.ProductUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeCatalogTest {

    @Test
    public void testGetProductByName() {

        Catalog catalog = new FakeCatalog();
        Product product1 = new Product("product1", ProductUnit.Each);
        catalog.addProduct(product1, 1);
        assertEquals(product1, catalog.getProductByName("product1"));

    }
}

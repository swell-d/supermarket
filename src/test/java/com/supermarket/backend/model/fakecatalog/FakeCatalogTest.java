package com.supermarket.backend.model.fakecatalog;

import com.supermarket.backend.model.Product;
import com.supermarket.backend.model.ProductUnit;
import com.supermarket.backend.model.SupermarketCatalog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeCatalogTest {

    @Test
    public void testGetProductByName() {

        SupermarketCatalog catalog = new FakeCatalog();
        Product product1 = new Product("product1", ProductUnit.Each);
        catalog.addProduct(product1, 1);
        assertEquals(product1, catalog.getProductByName("product1"));

    }
}

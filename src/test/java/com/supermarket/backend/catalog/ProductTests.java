package com.supermarket.backend.catalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTests {

    @Test
    public void createProductTest() {
        Product product = new Product("test article 1", "test name 1", ProductUnit.Each);
        assertNotNull(product);
        assertEquals("test article 1", product.getArticle());
        assertEquals("test name 1", product.getName());
        assertEquals(ProductUnit.Each, product.getUnit());
    }

    @Test
    public void compareProductsTest() {
        Product baseProduct = new Product("test article 1", "test name 1", ProductUnit.Each);
        Product sameProduct = new Product("test article 1", "test name 1", ProductUnit.Each);
        Product anotherArticleProduct = new Product("test article 2", "test name 1", ProductUnit.Each);
        Product anotherNameProduct = new Product("test article 1", "test name 2", ProductUnit.Each);
        Product anotherUnitProduct = new Product("test article 1", "test name 1", ProductUnit.Kilo);
        assertEquals(baseProduct, sameProduct);
        assertNotEquals(baseProduct, anotherArticleProduct);
        assertNotEquals(baseProduct, anotherNameProduct);
        assertNotEquals(baseProduct, anotherUnitProduct);
    }

}

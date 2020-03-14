package com.supermarket.backend.catalog;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTests {

    @Test
    public void createProductTest() {
        Product product = new Product("test article 1", "test name 1", ProductUnit.Each);
        assertNotNull(product);
        assertEquals("test article 1", product.getArticle());
        assertEquals("test name 1", product.getName());
        assertEquals(ProductUnit.Each, product.getUnit());

        product.setShortDescription("short description");
        assertEquals("short description", product.getShortDescription());

        product.setDescription("description");
        assertEquals("description", product.getDescription());

        product.setSmallImage("small image");
        assertEquals("small image", product.getSmallImage());

        product.setImage("image");
        assertEquals("image", product.getImage());
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
        assertEquals(baseProduct, anotherNameProduct);
        assertEquals(baseProduct, anotherUnitProduct);
    }

}

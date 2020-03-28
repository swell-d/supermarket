package com.supermarket.backend.catalog;

import com.supermarket.backend.catalog.domain.MeasurementUnit;
import com.supermarket.backend.catalog.domain.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTests {

    @Test
    public void createProductTest() {
        Product product = new Product("test article 1", "test name 1", MeasurementUnit.Each);
        assertNotNull(product);
        assertEquals("test article 1", product.article);
        assertEquals("test name 1", product.name);
        assertEquals(MeasurementUnit.Each, product.unit);
        product.shortDescription = "short description";
        assertEquals("short description", product.shortDescription);
        product.description = "description";
        assertEquals("description", product.description);
        product.smallImage = "small image";
        assertEquals("small image", product.smallImage);
        product.image = "image";
        assertEquals("image", product.image);
    }

    @Test
    public void compareProductsTest() {
        Product baseProduct = new Product("test article 1", "test name 1", MeasurementUnit.Each);
        Product sameProduct = new Product("test article 1", "test name 1", MeasurementUnit.Each);
        Product anotherArticleProduct = new Product("test article 2", "test name 1", MeasurementUnit.Each);
        Product anotherNameProduct = new Product("test article 1", "test name 2", MeasurementUnit.Each);
        Product anotherUnitProduct = new Product("test article 1", "test name 1", MeasurementUnit.Kilo);
        assertEquals(baseProduct, sameProduct);
        assertNotEquals(baseProduct, anotherArticleProduct);
        assertEquals(baseProduct, anotherNameProduct);
        assertEquals(baseProduct, anotherUnitProduct);
    }

}

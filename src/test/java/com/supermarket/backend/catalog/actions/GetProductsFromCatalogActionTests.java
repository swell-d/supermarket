package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;
import com.supermarket.backend.mock.MockCatalogFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProductsFromCatalogActionTests {

    @Test
    public void getProductsTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        List<Product.Importer> products = new GetProductsFromCatalogAction(mockCatalog).getProducts();
        assertEquals(mockCatalog.getProducts(), products);
    }

}

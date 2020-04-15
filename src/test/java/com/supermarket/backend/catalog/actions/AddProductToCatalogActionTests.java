package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;
import com.supermarket.backend.mock.MockCatalogFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductToCatalogActionTests {


    private Product.Importer productImporter;

    @Before
    public void setUp() throws Exception {
        productImporter = new StabImporter();
    }

    @Test
    public void addProductToCatalogTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        new AddProductToCatalogAction(mockCatalog).addProductToCatalog(productImporter);

        Product productByArticle = mockCatalog.byArticle("test article 1");
        assertEquals(productByArticle.article, productImporter.article());
        assertEquals(productByArticle.name, productImporter.name());
        assertEquals(productByArticle.unit, productByArticle.unit);
        assertEquals(productByArticle.prices, productImporter.prices());
    }

    @Test(expected = IllegalStateException.class)
    public void addExistProductToCatalogTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        new AddProductToCatalogAction(mockCatalog).addProductToCatalog(productImporter);
        new AddProductToCatalogAction(mockCatalog).addProductToCatalog(productImporter);
    }

}

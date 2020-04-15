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
        productImporter = StabImporterBuilder.importerBuilder().create();
    }

    @Test
    public void addProductToCatalogTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        new AddProductToCatalogAction(mockCatalog).addProductToCatalog(productImporter);
        Product productByArticle = mockCatalog.byArticle("defaultArticle");
        assertEquals(productByArticle, new Product(productImporter));
    }

    @Test(expected = IllegalStateException.class)
    public void addExistProductToCatalogTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        new AddProductToCatalogAction(mockCatalog).addProductToCatalog(productImporter);
        new AddProductToCatalogAction(mockCatalog).addProductToCatalog(productImporter);
    }
}
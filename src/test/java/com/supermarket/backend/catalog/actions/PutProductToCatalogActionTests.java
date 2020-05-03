package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;
import com.supermarket.backend.mock.MockCatalogFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PutProductToCatalogActionTests {

    private Product.Importer productImporter;

    @Before
    public void setUp() throws Exception {
        productImporter = StabImporterBuilder.importerBuilder().withArticle("Phone").withName("New phone!").create();
    }

    @Test
    public void putProductToCatalogTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        new PutProductToCatalogAction(mockCatalog).putProductToCatalog(productImporter);
        Product productByArticle = mockCatalog.byArticle("Phone");
        assertEquals(productByArticle.importer.name(), "New phone!");
    }

}

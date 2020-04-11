package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;
import com.supermarket.backend.mock.MockCatalogFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProductFromCatalogByArticleActionTests {

    @Test
    public void getProductByArticleTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        Product product = new GetProductFromCatalogByArticleAction(mockCatalog).getProductByArticle("Phone");
        assertEquals(mockCatalog.getProductByArticle("Phone"), product);
    }

}

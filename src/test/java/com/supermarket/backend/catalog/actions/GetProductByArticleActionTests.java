package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;
import com.supermarket.backend.mock.MockCatalogFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProductByArticleActionTests {

    @Test
    public void getProductByArticleTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        Product product = new GetProductByArticleAction(mockCatalog).getProductByArticle("Phone");
        assertEquals(mockCatalog.byArticle("Phone"), product);
    }

}

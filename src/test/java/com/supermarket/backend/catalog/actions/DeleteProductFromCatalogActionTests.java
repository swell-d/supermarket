package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.mock.MockCatalogFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteProductFromCatalogActionTests {

    @Test
    public void deleteProductFromCatalogTest() {
        Catalog mockCatalog = new MockCatalogFactory().createMockCatalog();
        new DeleteProductFromCatalogAction(mockCatalog).deleteProductFromCatalog("Phone");
        assertEquals(3, mockCatalog.getProducts().size());
    }

}

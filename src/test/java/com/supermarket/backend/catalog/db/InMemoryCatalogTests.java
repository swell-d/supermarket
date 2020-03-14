package com.supermarket.backend.catalog.db;

import com.supermarket.backend.catalog.db.memory.InMemoryCatalog;
import org.junit.Test;

import static com.supermarket.backend.catalog.db.CatalogTests.*;

public class InMemoryCatalogTests {

    @Test
    public void inMemoryCatalogTests() {
        createCatalogTest(new InMemoryCatalog());
        addProductTest(new InMemoryCatalog());
        deleteProductTest(new InMemoryCatalog());
        getProductByNameTest(new InMemoryCatalog());
        checkExistsProductTest(new InMemoryCatalog());
    }

}

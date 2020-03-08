package com.supermarket.backend.catalog.db;

import com.supermarket.backend.catalog.db.array.ArrayCatalog;
import org.junit.jupiter.api.Test;

import static com.supermarket.backend.catalog.db.CatalogTests.*;

public class ArrayCatalogTests {

    @Test
    public void hashMapCatalogTests() {
        createCatalogTest(new ArrayCatalog());
        addProductTest(new ArrayCatalog());
        deleteProductTest(new ArrayCatalog());
        getProductByNameTest(new ArrayCatalog());
    }

}

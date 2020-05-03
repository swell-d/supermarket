package com.supermarket.backend.catalog.db.mongo;

import com.supermarket.backend.catalog.db.DBTests;
import com.supermarket.backend.catalog.domain.CatalogTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MongoCatalogTests implements DBTests {

    @Autowired
    private MongoProductRepository mongoCatalog;

    @Test
    public void createCatalog() throws Exception {
        mongoCatalog.deleteAll();
        CatalogTests.createCatalog(new MongoCatalogAdapter(mongoCatalog));
    }

    @Test
    public void addProduct() throws Exception {
        mongoCatalog.deleteAll();
        CatalogTests.addProduct(new MongoCatalogAdapter(mongoCatalog));
    }

    @Test
    public void addProductTwiceShouldFail() throws Exception {
        mongoCatalog.deleteAll();
        assertThrows(
                IllegalStateException.class,
                () -> {
                    CatalogTests.addProductTwiceShouldFail(new MongoCatalogAdapter(mongoCatalog));
                }
        );
    }

    @Test
    public void deleteProduct() throws Exception {
        mongoCatalog.deleteAll();
        CatalogTests.deleteProduct(new MongoCatalogAdapter(mongoCatalog));
    }

    @Test
    public void deleteProductTwice() throws Exception {
        mongoCatalog.deleteAll();
        assertThrows(
                IllegalStateException.class,
                () -> {
                    CatalogTests.deleteProductTwice(new MongoCatalogAdapter(mongoCatalog));
                }
        );
    }

    @Test
    public void checkFailureOnSameArticle() throws Exception {
        mongoCatalog.deleteAll();
        assertThrows(
                IllegalStateException.class,
                () -> {
                    CatalogTests.checkFailureOnSameArticle(new MongoCatalogAdapter(mongoCatalog));
                }
        );
    }

}

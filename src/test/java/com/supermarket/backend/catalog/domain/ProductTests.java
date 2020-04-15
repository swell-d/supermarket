package com.supermarket.backend.catalog.domain;

import com.supermarket.backend.catalog.actions.StabImporter;
import com.supermarket.backend.catalog.actions.StabImporterBuilder;
import org.junit.Before;
import org.junit.Test;

import static com.supermarket.backend.catalog.actions.StabImporterBuilder.importerBuilder;
import static org.junit.Assert.*;

public class ProductTests {

    private StabImporter stabImporter;
    private StabImporterBuilder importerBuilder;

    @Before
    public void setUp() throws Exception {
        importerBuilder = importerBuilder();
        stabImporter = importerBuilder
                .withArticle("test article 1")
                .withName("test name 1")
                .withMesUnit(MeasurementUnit.Each)
                .create();
    }

    @Test
    public void compareSameProducts(){
        Product baseProduct = new Product(stabImporter);
        Product sameProduct = new Product(stabImporter);
        assertEquals(baseProduct, sameProduct);
    }


    @Test
    public void compareNotSameProducts() {
        Product baseProduct = new Product(stabImporter);
        Product anotherArticleProduct = new Product(importerBuilder.withArticle("test article 2").create());
        Product anotherNameProduct = new Product(importerBuilder.withName("test name 2").create());
        Product anotherUnitProduct = new Product(importerBuilder.withMesUnit(MeasurementUnit.Kilo).create());
        assertNotEquals(baseProduct, anotherArticleProduct);
        assertNotEquals(baseProduct, anotherNameProduct);
        assertNotEquals(baseProduct, anotherUnitProduct);
    }

}

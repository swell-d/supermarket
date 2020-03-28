package com.supermarket.backend.catalog.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.PriceCategory;
import com.supermarket.backend.catalog.domain.Product;

import java.util.ArrayList;
import java.util.Map;

public class GetCatalogAction {

    private Catalog catalog;

    public GetCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }
}

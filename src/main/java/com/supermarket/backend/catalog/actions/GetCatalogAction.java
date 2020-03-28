package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;

public class GetCatalogAction {

    private Catalog catalog;

    public GetCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }
}

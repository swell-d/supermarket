package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.ChangeProductInCatalogAction;
import com.supermarket.backend.catalog.domain.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public class ChangeProductInCatalog {

    private ChangeProductInCatalogAction changeProductInCatalogAction;

    public ChangeProductInCatalog(ChangeProductInCatalogAction changeProductInCatalogAction) {
        this.changeProductInCatalogAction = changeProductInCatalogAction;
    }

    @PutMapping("/catalog/{article}")
    public Product product(@PathVariable String article) {
        return changeProductInCatalogAction.changeProductInCatalog(article);
    }

}

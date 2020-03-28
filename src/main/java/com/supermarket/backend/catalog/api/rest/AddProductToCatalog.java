package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.AddProductToCatalogAction;
import com.supermarket.backend.catalog.domain.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddProductToCatalog {

    private AddProductToCatalogAction addProductToCatalogAction;

    public AddProductToCatalog(AddProductToCatalogAction addProductToCatalogAction) {
        this.addProductToCatalogAction = addProductToCatalogAction;
    }

    @PostMapping("/catalog")
    public Product product() {
        return addProductToCatalogAction.addProductToCatalog();
    }
}

package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.GetProductsFromCatalogAction;
import com.supermarket.backend.catalog.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetProductsFromCatalogController {

    private final GetProductsFromCatalogAction action;

    public GetProductsFromCatalogController(GetProductsFromCatalogAction action) {
        this.action = action;
    }

    @GetMapping(path = "/catalog", produces = "application/json")
    public List<Product.Importer> getCatalog() {
        return action.getProducts();
    }

}

package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.GetCatalogAction;
import com.supermarket.backend.catalog.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetCatalog {

    private GetCatalogAction getCatalogAction;

    public GetCatalog(GetCatalogAction getCatalogAction) {
        this.getCatalogAction = getCatalogAction;
    }

    @GetMapping("/catalog")
    public List<Product> catalog() {
        return getCatalogAction.getCatalog().getCatalog();
    }
}

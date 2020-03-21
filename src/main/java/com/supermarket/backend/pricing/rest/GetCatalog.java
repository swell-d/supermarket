package com.supermarket.backend.pricing.rest;

import com.supermarket.backend.pricing.actions.GetCatalogAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GetCatalog {

    private GetCatalogAction getCatalogAction;

    public GetCatalog(GetCatalogAction getCatalogAction) {
        this.getCatalogAction = getCatalogAction;
    }

    @GetMapping("/catalog")
    public ArrayList catalog() {
        return getCatalogAction.getCatalog();
    }
}

package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.DeleteProductFromCatalogAction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteProductFromCatalogController {

    private final DeleteProductFromCatalogAction action;

    public DeleteProductFromCatalogController(DeleteProductFromCatalogAction action) {
        this.action = action;
    }

    @DeleteMapping(path = "/catalog/{article}")
    public String deleteProductFromCatalog(@PathVariable String article) {
        try {
            action.deleteProductFromCatalog(article);
            return "200";
        } catch (IllegalStateException e) {
            return "409";
        }
    }

}

package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.DeleteProductFromCatalogAction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DeleteProductFromCatalogController {

    private final DeleteProductFromCatalogAction action;

    public DeleteProductFromCatalogController(DeleteProductFromCatalogAction action) {
        this.action = action;
    }

    @DeleteMapping(path = "/catalog/{article}")
    public void deleteProductFromCatalog(@PathVariable String article) {
        try {
            action.deleteProductFromCatalog(article);
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Error: product not exist"
            );
        }
    }

}

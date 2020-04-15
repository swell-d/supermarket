package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.AddProductToCatalogAction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AddProductToCatalogController {

    private final AddProductToCatalogAction action;

    public AddProductToCatalogController(AddProductToCatalogAction action) {
        this.action = action;
    }

    @PostMapping(path = "/catalog", consumes = "application/json", produces = "application/json")
    public void addProductToCatalog(@RequestBody AddProductRequest apr) {
        try {
            action.addProductToCatalog(apr);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Product already exist"
            );
        }
    }

}

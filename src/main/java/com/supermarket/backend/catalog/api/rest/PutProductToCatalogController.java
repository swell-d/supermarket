package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.PutProductToCatalogAction;
import com.supermarket.backend.catalog.domain.AddProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PutProductToCatalogController {

    private final PutProductToCatalogAction action;

    public PutProductToCatalogController(PutProductToCatalogAction action) {
        this.action = action;
    }

    @PutMapping(path = "/catalog", consumes = "application/json", produces = "application/json")
    public void putProductToCatalog(@RequestBody AddProductRequest productRequest) {
        try {
            action.putProductToCatalog(productRequest);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Product not exist"
            );
        }
    }

}

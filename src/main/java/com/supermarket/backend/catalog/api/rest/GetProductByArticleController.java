package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.GetProductByArticleAction;
import com.supermarket.backend.catalog.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProductByArticleController {

    private final GetProductByArticleAction action;

    public GetProductByArticleController(GetProductByArticleAction action) {
        this.action = action;
    }

    @GetMapping(path = "/catalog/{article}", produces = "application/json")
    public Product getProductFromCatalog(@PathVariable String article) {
        return action.getProductByArticle(article);
    }
}

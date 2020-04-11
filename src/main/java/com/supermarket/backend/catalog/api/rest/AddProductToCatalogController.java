package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.AddProductToCatalogAction;
import com.supermarket.backend.catalog.actions.GetProductFromCatalogByArticleAction;
import com.supermarket.backend.catalog.domain.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddProductToCatalogController {

    private final AddProductToCatalogAction addProductToCatalogAction;
    private final GetProductFromCatalogByArticleAction getProductFromCatalogByArticleAction;

    public AddProductToCatalogController(AddProductToCatalogAction addProductToCatalogAction,
                                         GetProductFromCatalogByArticleAction getProductFromCatalogByArticleAction) {
        this.addProductToCatalogAction = addProductToCatalogAction;
        this.getProductFromCatalogByArticleAction = getProductFromCatalogByArticleAction;
    }

    @PostMapping(path = "/catalog", consumes = "application/json", produces = "application/json")
    public Product addProductToCatalog(@RequestBody Product newProduct) {
        Product product = getProductFromCatalogByArticleAction.getProductByArticle(newProduct.article);
        if (product == null) {
            addProductToCatalogAction.addProductToCatalog(newProduct);
            return getProductFromCatalogByArticleAction.getProductByArticle(newProduct.article);
        }
        return null;
    }

}

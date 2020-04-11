package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.DeleteProductFromCatalogAction;
import com.supermarket.backend.catalog.actions.GetProductFromCatalogByArticleAction;
import com.supermarket.backend.catalog.domain.Product;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteProductFromCatalogController {

    private final DeleteProductFromCatalogAction deleteProductFromCatalogAction;
    private final GetProductFromCatalogByArticleAction getProductFromCatalogByArticleAction;

    public DeleteProductFromCatalogController(DeleteProductFromCatalogAction deleteProductFromCatalogAction,
                                              GetProductFromCatalogByArticleAction getProductFromCatalogByArticleAction) {
        this.deleteProductFromCatalogAction = deleteProductFromCatalogAction;
        this.getProductFromCatalogByArticleAction = getProductFromCatalogByArticleAction;
    }

    @DeleteMapping(path = "/catalog/{article}")
    public String deleteProductFromCatalog(@PathVariable String article) {
        Product product = getProductFromCatalogByArticleAction.getProductByArticle(article);
        if (product != null) {
            deleteProductFromCatalogAction.deleteProductFromCatalog(product);
            return "OK";
        }
        return "Product not exist";
    }

}

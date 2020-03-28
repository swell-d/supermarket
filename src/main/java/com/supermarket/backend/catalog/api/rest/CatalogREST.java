package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.CatalogActions;
import com.supermarket.backend.catalog.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogREST {

    private final CatalogActions catalogActions;

    public CatalogREST(CatalogActions catalogActions) {
        this.catalogActions = catalogActions;
    }

    @GetMapping(path = "/catalog", produces = "application/json")
    public List<Product> getCatalog() {
        return catalogActions.getProducts();
    }

    @GetMapping(path = "/catalog/{article}", produces = "application/json")
    public Product getProductFromCatalog(@PathVariable String article) {
        return catalogActions.getProductByArticle(article);
    }

    @PostMapping(path = "/catalog", consumes = "application/json", produces = "application/json")
    public Product addProductToCatalog(@RequestBody Product newProduct) {
        Product product = catalogActions.getProductByArticle(newProduct.article);
        if (product == null) {
            catalogActions.addProductToCatalog(newProduct);
            return catalogActions.getProductByArticle(newProduct.article);
        }
        return null;
    }

    @PutMapping(path = "/catalog/{article}", consumes = "application/json", produces = "application/json")
    public Product changeProductInCatalog(@PathVariable String article, @RequestBody Product newProductData) {
        Product product = catalogActions.getProductByArticle(article);
        if (product != null) {
            catalogActions.changeProductInCatalog(product, newProductData);
            return catalogActions.getProductByArticle(article);
        }
        return null;
    }

    @DeleteMapping(path = "/catalog/{article}")
    public String deleteProductFromCatalog(@PathVariable String article) {
        Product product = catalogActions.getProductByArticle(article);
        if (product != null) {
            catalogActions.deleteProductFromCatalog(product);
            return "OK";
        }
        return "Product not exist";
    }

}

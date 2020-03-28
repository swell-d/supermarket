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

    @GetMapping("/catalog")
    public List<Product> getCatalog() {
        return catalogActions.getCatalog().getProducts();
    }

    @PostMapping("/catalog")
    public Product addProductToCatalog(@RequestBody Product newProduct) {
        catalogActions.addProductToCatalog(newProduct);
        return catalogActions.getProductByArticle(newProduct.article);
    }

    @GetMapping("/catalog/{article}")
    public Product getProductFromCatalog(@PathVariable String article) {
        return catalogActions.getProductByArticle(article);
    }

    @PutMapping("/catalog/{article}")
    public Product changeProductInCatalog(@PathVariable String article, @RequestBody Product newProduct) {
        catalogActions.changeProductInCatalog(article, newProduct);
        return catalogActions.getProductByArticle(newProduct.article);
    }

    @DeleteMapping("/catalog/{article}")
    public String deleteProductFromCatalog(@PathVariable String article) {
        Product product = catalogActions.getProductByArticle(article);
        if (product != null) {
            catalogActions.deleteProductFromCatalog(product);
            return "OK";
        }
        return "Product not exist";
    }

}

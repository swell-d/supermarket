package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

public class AddProductToCatalogAction {

    private Catalog catalog;

    public AddProductToCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public void addProductToCatalog(Product newProduct) {
        Product exist_product = catalog.getProductByArticle(newProduct.article);
        if (exist_product == null) {
            validateData(newProduct);
            catalog.addProduct(newProduct);
            return;
        }
        throw new IllegalStateException();
    }

    private void validateData(Product product) {
        String urlPattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        if (product.article.length() == 0) throw new IllegalArgumentException("'Article' is required");
        if (product.name.length() == 0) throw new IllegalArgumentException("'Name' is required");
        if (!product.smallImage.equals("") && !product.smallImage.matches(urlPattern))
            throw new IllegalArgumentException("'smallImage' path is invalid");
        if (!product.image.equals("") && !product.image.matches(urlPattern))
            throw new IllegalArgumentException("'image' path is invalid");
        if (!product.prices.containsKey("Base")) throw new IllegalArgumentException("'Base' price is required");
        if (product.prices.get("Base") < 0) throw new IllegalArgumentException("Price shoud not be < 0");
    }

}

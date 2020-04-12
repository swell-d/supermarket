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
        String result = "";
        String urlPattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        if (product.article.length() == 0) result += "'Article' is required. ";
        if (product.name.length() == 0) result += "'Name' is required. ";
        if (!product.smallImage.equals("") && !product.smallImage.matches(urlPattern))
            result += "'smallImage' path is invalid. ";
        if (!product.image.equals("") && !product.image.matches(urlPattern))
            result += "'image' path is invalid. ";
        if (!product.prices.containsKey("Base")) result += "'Base' price is required. ";
        if (product.prices.containsKey("Base") && product.prices.get("Base") < 0)
            result += "Price shoud not be negative. ";

        if (!result.equals("")) throw new IllegalArgumentException(result);
    }

}
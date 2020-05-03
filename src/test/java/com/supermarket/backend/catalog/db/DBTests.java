package com.supermarket.backend.catalog.db;

public interface DBTests {

    public void createCatalog() throws Exception;

    public void addProduct() throws Exception;

    public void addProductTwiceShouldFail() throws Exception;

    public void editProduct() throws Exception;

    public void deleteProduct() throws Exception;

    public void deleteProductTwice() throws Exception;

    public void checkFailureOnSameArticle() throws Exception;

}

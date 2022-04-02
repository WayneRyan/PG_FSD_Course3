package com.model;

public class Product {
    private int productID;
    private String productDetails;

    public Product(int productID, String productDetails) {
        this.productID = productID;
        this.productDetails = productDetails;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }
}

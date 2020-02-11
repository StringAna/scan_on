package com.project.scan_on;

public class HorizontalProductScrollModel {

    private int productImage;
    private String productTittle;
    private String productDescription;
    private String productPrice;

    public HorizontalProductScrollModel(int productImage, String productTittle, String productDescription, String productPrice) {
        this.productImage = productImage;
        this.productTittle = productTittle;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTittle() {
        return productTittle;
    }

    public void setProductTittle(String productTittle) {
        this.productTittle = productTittle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}

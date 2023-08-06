package com.stuti.amazon;

public class Product {
    private Long productId ;
    private String productName ;
    private String productSpec ;
    private  Long price ;
    private String review;

    public Product(Long productId, String productName, String productSpec, Long price, String review) {
        this.productId = productId;
        this.productName = productName;
        this.productSpec = productSpec;
        this.price = price;
        this.review = review;
    }

    public Product() {

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

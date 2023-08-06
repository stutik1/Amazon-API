package com.stuti.amazon;

public class Cart {
    private int cartId ;
    private Long userid ;
    private int productQuantity;

    public Cart(int cartId, Long userid, int productQuantity) {
        this.cartId = cartId;
        this.userid = userid;
        this.productQuantity = productQuantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}

package com.stuti.amazon;

import java.sql.Timestamp;

public class Order {
    private Long orderId ;
    private Timestamp orderDate ;
    private Long orderAmount ;
    private int productQuantity;
    private Long userid ;
    private Long productId ;
    private OrderStatusType status;

    public Order(Long orderId, Timestamp orderDate, Long orderAmount, int productQuantity, Long userid, Long productId, OrderStatusType status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.productQuantity = productQuantity;
        this.userid = userid;
        this.productId = productId;
        this.status = status;
    }

    public Order() {

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }
}

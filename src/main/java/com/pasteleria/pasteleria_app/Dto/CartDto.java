package com.pasteleria.pasteleria_app.Dto;

public class CartDto {
    private long cart_id;
    private String product_id;

    public CartDto() {
    }

    public CartDto(long cart_id, String product_id) {
        this.cart_id = cart_id;
        this.product_id = product_id;
    }

    public long getCart_id() {
        return cart_id;
    }

    public void setCart_id(long cart_id) {
        this.cart_id = cart_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
}

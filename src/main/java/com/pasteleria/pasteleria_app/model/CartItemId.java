package com.pasteleria.pasteleria_app.model;

import java.io.Serializable;
import java.util.Objects;

public class CartItemId implements Serializable {

    private Long product;
    private String cart;

    // Constructor por defecto
    public CartItemId() {}

    // Constructor con parámetros
    public CartItemId(Long product, String cart) {
        this.product = product;
        this.cart = cart;
    }

    // Getters y Setters
    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemId that = (CartItemId) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, cart);
    }
}

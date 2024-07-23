package com.pasteleria.pasteleria_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_id;

    @ManyToOne
    @JoinColumn(name = "id_number", nullable = false)
    private AppUser id_number;

    public Cart() {
    }

    public Cart(long cart_id, AppUser id_number) {
        this.cart_id = cart_id;
        this.id_number = id_number;
    }

    public long getCart_id() {
        return cart_id;
    }

    public void setCart_id(long cart_id) {
        this.cart_id = cart_id;
    }

    public AppUser getId_number() {
        return id_number;
    }

    public void setId_number(AppUser id_number) {
        this.id_number = id_number;
    }

}

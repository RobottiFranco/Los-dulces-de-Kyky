package com.pasteleria.pasteleria_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_item_id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private PurchaseOrder order_id;

    @ManyToOne
    @JoinColumn(name = "id_number", nullable = false)
    private Product product_id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    public OrderItem() {
    }

    public OrderItem(long order_item_id, PurchaseOrder order_id, Product product_id, int quantity, double price) {
        this.order_item_id = order_item_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public long getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(long order_item_id) {
        this.order_item_id = order_item_id;
    }

    public PurchaseOrder getOrder_id() {
        return order_id;
    }

    public void setOrder_id(PurchaseOrder order_id) {
        this.order_id = order_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

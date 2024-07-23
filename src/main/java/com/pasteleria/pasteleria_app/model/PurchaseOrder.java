package com.pasteleria.pasteleria_app.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user_id;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created_at;

    @Column(nullable = false)
    private double total_amount;

    public PurchaseOrder() {
    }

    public PurchaseOrder(long order_id, AppUser user_id, Date created_at, double total_amount) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.created_at = created_at;
        this.total_amount = total_amount;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public AppUser getUser_id() {
        return user_id;
    }

    public void setUser_id(AppUser user_id) {
        this.user_id = user_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
}

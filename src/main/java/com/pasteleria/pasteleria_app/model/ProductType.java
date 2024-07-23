package com.pasteleria.pasteleria_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_type_id;

    @Column(nullable = false, unique = true)
    private String name;

    public ProductType() {
    }

    public ProductType(long product_type_id, String name) {
        this.product_type_id = product_type_id;
        this.name = name;
    }

    public long getProduct_type_id() {
        return product_type_id;
    }

    public void setProduct_type_id(long product_type_id) {
        this.product_type_id = product_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

}

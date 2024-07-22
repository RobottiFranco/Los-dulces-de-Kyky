package com.pasteleria.pasteleria_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductTypeMapping {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType product_type_id;

    public ProductTypeMapping() {
    }

    public ProductTypeMapping(Product product_id, ProductType product_type_id) {
        this.product_id = product_id;
        this.product_type_id = product_type_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public ProductType getProduct_type_id() {
        return product_type_id;
    }

    public void setProduct_type_id(ProductType product_type_id) {
        this.product_type_id = product_type_id;
    }

}

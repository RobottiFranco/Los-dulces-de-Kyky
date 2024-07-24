package com.pasteleria.pasteleria_app.service;

import java.util.List;

import com.pasteleria.pasteleria_app.model.Product;

public interface ProductService {

    public void addProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(long id);

    public List<Product> getProduct();

    public Product getProductByID(long id);

    public List<Product> getProductByTypeName(String productType);

    public List<Product> getProductByTypeID(long productType);
}

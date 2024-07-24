package com.pasteleria.pasteleria_app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasteleria.pasteleria_app.model.Product;
import com.pasteleria.pasteleria_app.repository.ProductRepository;
import com.pasteleria.pasteleria_app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product) {
        if (productRepository.existsById(product.getProductId())) {
            throw new RuntimeException("Product with this ID already exists");
        }
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        if (productRepository.existsById(product.getProductId())) {
            productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public void deleteProduct(long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public Product getProductByID(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProductByTypeName(String productType) {
        return productRepository.getProductByTypeName(productType);
    }

    @Override
    public List<Product> getProductByTypeID(long productType) {
        return productRepository.getProductByTypeID(productType);
    }

}

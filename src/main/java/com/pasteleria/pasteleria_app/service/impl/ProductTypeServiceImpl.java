package com.pasteleria.pasteleria_app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasteleria.pasteleria_app.exception.CustomExceptions;
import com.pasteleria.pasteleria_app.model.ProductType;
import com.pasteleria.pasteleria_app.repository.ProductTypeRepository;
import com.pasteleria.pasteleria_app.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getProductType() {
        try {
            return productTypeRepository.findAll();
        } catch (Exception e) {
            throw new CustomExceptions(e.getMessage());
        }
    }

    @Override
    public ProductType getProductTypeByID(long id) {
        try {
            return productTypeRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new CustomExceptions(e.getMessage());
        }
    }

    @Override
    public void addProductType(ProductType productType) {
        try {
            productTypeRepository.save(productType);
        } catch (Exception e) {
            throw new CustomExceptions(e.getMessage());
        }
    }

    @Override
    public void updateProductType(ProductType productType) {
        try {
            productTypeRepository.save(productType);
        } catch (Exception e) {
            throw new CustomExceptions(e.getMessage());
        }
    }

    @Override
    public void deleteProductType(long id) {
        try {
            productTypeRepository.deleteById(id);
        } catch (Exception e) {
            throw new CustomExceptions(e.getMessage());
        }
    }
}

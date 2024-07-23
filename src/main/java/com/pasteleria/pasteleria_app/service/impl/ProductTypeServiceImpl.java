package com.pasteleria.pasteleria_app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pasteleria.pasteleria_app.model.ProductType;
import com.pasteleria.pasteleria_app.repository.ProductTypeRepository;
import com.pasteleria.pasteleria_app.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getProductType() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType getProductTypeByID(long id) {
        return productTypeRepository.findById(id).orElse(null);
    }

}

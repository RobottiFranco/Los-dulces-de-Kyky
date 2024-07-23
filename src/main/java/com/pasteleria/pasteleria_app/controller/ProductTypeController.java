package com.pasteleria.pasteleria_app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.pasteleria.pasteleria_app.model.ProductType;
import com.pasteleria.pasteleria_app.service.ProductTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/getAllTypes")
    public ResponseEntity<List<ProductType>> getProductType() {
        List<ProductType> productType = productTypeService.getProductType();
        return ResponseEntity.ok(productType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductType> getProductTypeByID(@PathVariable long id) {
        return ResponseEntity.ok(productTypeService.getProductTypeByID(id));
    }

}

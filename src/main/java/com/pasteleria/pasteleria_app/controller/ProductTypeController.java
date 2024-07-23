package com.pasteleria.pasteleria_app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pasteleria.pasteleria_app.model.ProductType;
import com.pasteleria.pasteleria_app.service.ProductTypeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
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

    @PostMapping("/addProductType")
    public ResponseEntity<Void> addProductType(@RequestBody ProductType productType) {
        productTypeService.addProductType(productType);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/updateProductType")
    public ResponseEntity<Void> updateProductType(@RequestBody ProductType productType) {
        productTypeService.updateProductType(productType);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteProductType/{id}")
    public ResponseEntity<Void> deleteProductType(@PathVariable long id) {
        productTypeService.deleteProductType(id);
        return ResponseEntity.ok().build();
    }

}

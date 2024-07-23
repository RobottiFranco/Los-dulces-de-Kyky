package com.pasteleria.pasteleria_app.controller;

import org.springframework.web.bind.annotation.RestController;
import com.pasteleria.pasteleria_app.model.Product;
import com.pasteleria.pasteleria_app.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getProduct() {
        List<Product> product = productService.getProduct();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable long id) {
        return ResponseEntity.ok(productService.getProductByID(id));
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Void> updateProduct(Product product) {
        productService.updateProduct(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Void> addProduct(Product product) {
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /*
     * @GetMapping("/{productType}")
     * public ResponseEntity<List<Product>> getProductByType(@PathVariable String
     * productType) {
     * List<Product> product = productService.getProductByType(productType);
     * return ResponseEntity.ok(product);
     * }
     */

}

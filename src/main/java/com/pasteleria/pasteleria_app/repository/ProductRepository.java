package com.pasteleria.pasteleria_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pasteleria.pasteleria_app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN ProductTypeMapping ptm ON p.productId = ptm.product.productId JOIN ProductType pt ON ptm.productType.productTypeId = pt.productTypeId WHERE pt.name = ?1")
    List<Product> getProductByTypeName(String typeName);

    @Query("SELECT p FROM Product p JOIN ProductTypeMapping ptm ON p.productId = ptm.product.productId JOIN ProductType pt ON ptm.productType.productTypeId = pt.productTypeId WHERE pt.productTypeId = ?1")
    List<Product> getProductByTypeID(long typeName);

}

package com.pasteleria.pasteleria_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pasteleria.pasteleria_app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
/*     @Query("SELECT p FROM Product p JOIN ProductTypeMapping ptm ON p.product_id = ptm.product_id " +
           "JOIN ProductType pt ON ptm.product_type_id = pt.product_type_id " +
           "WHERE pt.name = :typeName")
    List<Product> getProductByType(@Param("typeName") String typeName); */
}


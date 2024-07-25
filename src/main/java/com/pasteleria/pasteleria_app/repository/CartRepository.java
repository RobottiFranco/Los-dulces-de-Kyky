package com.pasteleria.pasteleria_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasteleria.pasteleria_app.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {

}

package com.pasteleria.pasteleria_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pasteleria.pasteleria_app.model.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
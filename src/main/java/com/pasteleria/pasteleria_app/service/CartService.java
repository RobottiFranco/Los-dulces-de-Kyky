package com.pasteleria.pasteleria_app.service;

import com.pasteleria.pasteleria_app.exception.CustomExceptions;
import com.pasteleria.pasteleria_app.model.Cart;

public interface CartService {

    public void initializeCart(String sessionId);

    public Cart getCart(String sessionId);

    public void addItemToCart(String sessionId, Long productId, int quantity) throws CustomExceptions;

    public void removeItemFromCart(String sessionId, Long productId) throws CustomExceptions;

    public double getTotalAmount(String sessionId);

    public void clearCart(String sessionId);
}

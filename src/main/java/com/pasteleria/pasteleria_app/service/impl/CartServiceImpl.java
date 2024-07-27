package com.pasteleria.pasteleria_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasteleria.pasteleria_app.exception.CustomExceptions;
import com.pasteleria.pasteleria_app.model.Cart;
import com.pasteleria.pasteleria_app.model.CartItem;
import com.pasteleria.pasteleria_app.model.Product;
import com.pasteleria.pasteleria_app.repository.CartRepository;
import com.pasteleria.pasteleria_app.repository.ProductRepository;
import com.pasteleria.pasteleria_app.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public void initializeCart(String sessionId) {
        if (!cartRepository.existsById(sessionId)) {
            Cart cart = new Cart(sessionId);
            cartRepository.save(cart);
        }
    }

    public Cart getCart(String sessionId) {
        return cartRepository.findById(sessionId).orElse(new Cart(sessionId));
    }

    public void addItemToCart(String sessionId, Long productId, int quantity) throws CustomExceptions {
        Cart cart = getCart(sessionId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new CustomExceptions("Product not found"));
        CartItem cartItem = new CartItem(product, cart, quantity);
        cart.addItem(cartItem);
        cartRepository.save(cart);
    }

    public void removeItemFromCart(String sessionId, Long productId) throws CustomExceptions {
        Cart cart = getCart(sessionId);
        CartItem item = cart.getItems().stream()
                .filter(cartItem -> cartItem.getProduct().getProductId() == productId)
                .findFirst()
                .orElseThrow(() -> new CustomExceptions("Item not found"));
        cart.getItems().remove(item);
        cartRepository.save(cart);
    }

    public double getTotalAmount(String sessionId) {
        Cart cart = getCart(sessionId);
        return cart.getTotalAmount();
    }

    public void clearCart(String sessionId) {
        Cart cart = getCart(sessionId);
        cart.clearItems();
        cartRepository.save(cart);
    }
}

package com.pasteleria.pasteleria_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pasteleria.pasteleria_app.exception.CustomExceptions;
import com.pasteleria.pasteleria_app.model.Cart;
import com.pasteleria.pasteleria_app.service.CartService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/initialize")
    public String initializeCart(HttpSession session) {
        String sessionId = session.getId();
        cartService.initializeCart(sessionId);
        return "Session ID: " + sessionId;
    }

    // Obtener el contenido del carrito
    @GetMapping
    public Cart getCart(HttpSession session) {
        String sessionId = session.getId();
        return cartService.getCart(sessionId);
    }

    // Agregar un ítem al carrito
    @PostMapping("/add")
    public String addItemToCart(HttpSession session, @RequestParam Long productId, @RequestParam int quantity) {
        String sessionId = session.getId();
        try {
            cartService.addItemToCart(sessionId, productId, quantity);
            return "Item added to cart";
        } catch (CustomExceptions e) {
            return e.getMessage();
        }
    }

    // Remover un ítem del carrito
    @DeleteMapping("/remove")
    public String removeItemFromCart(HttpSession session, @RequestParam Long productId) {
        String sessionId = session.getId();
        try {
            cartService.removeItemFromCart(sessionId, productId);
            return "Item removed from cart";
        } catch (CustomExceptions e) {
            return e.getMessage();
        }
    }

    // Limpiar el carrito
    @DeleteMapping("/clear")
    public String clearCart(HttpSession session) {
        String sessionId = session.getId();
        cartService.clearCart(sessionId);
        return "Cart cleared";
    }

    // Obtener el total del carrito
    @GetMapping("/total")
    public double getTotalAmount(HttpSession session) {
        String sessionId = session.getId();
        return cartService.getTotalAmount(sessionId);
    }
}

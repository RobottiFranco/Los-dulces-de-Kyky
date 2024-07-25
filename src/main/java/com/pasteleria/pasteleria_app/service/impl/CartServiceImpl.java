package com.pasteleria.pasteleria_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasteleria.pasteleria_app.repository.CartRepository;
import com.pasteleria.pasteleria_app.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

}

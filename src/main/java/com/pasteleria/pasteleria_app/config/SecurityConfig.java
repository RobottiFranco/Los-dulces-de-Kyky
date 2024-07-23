package com.pasteleria.pasteleria_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Desactiva CSRF para simplificar las pruebas
            .authorizeRequests(authorizeRequests -> authorizeRequests
                .anyRequest().permitAll() // Permite acceso a todos los endpoints sin autenticación
            );

        return http.build();
    }
}

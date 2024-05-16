package com.example.springboot.beansscope.services;

import com.example.springboot.beansscope.beans.Product;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
//@Scope("request")
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartRequest {
    private final List<Product> cart= new ArrayList<>();

    private static int instanceCounter = 0;

    public ShoppingCartRequest() {
        instanceCounter++;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Request bean created. Total instances: " + instanceCounter);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Request bean destroyed. Total instances: " + (--instanceCounter));
    }

    public void addToCart(Product product){
        cart.add(product);
    }
}

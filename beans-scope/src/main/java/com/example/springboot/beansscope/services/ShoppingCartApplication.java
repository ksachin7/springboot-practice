package com.example.springboot.beansscope.services;

import com.example.springboot.beansscope.beans.Product;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
@Scope("application")
public class ShoppingCartApplication {
    private static int instanceCounter = 0;
    private final List<Product> cart= new ArrayList<>();

    public ShoppingCartApplication() {
        instanceCounter++;
    }

    @PostConstruct
    public void init() {
        System.out.println("Application bean created. Total instances: " + instanceCounter);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Application bean destroyed. Total instances: " + (--instanceCounter));
    }

    public void addToCart(Product product){
        cart.add(product);
    }

    @Override
    public String toString() {
        return "ShoppingCartApplication{" +
                "cart=" + cart +
                '}';
    }
}

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
//@Scope("singleton")
public class ShoppingCartSingleton {
    private final List<Product> cart= new ArrayList<>();
    private static int instanceCounter = 0;

    public ShoppingCartSingleton() {
        instanceCounter++;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Singleton bean created. Total instances: " + instanceCounter);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Singleton bean destroyed. Total instances: " + (--instanceCounter));
    }

    public void addToCart(Product product){
        cart.add(product);
    }

}

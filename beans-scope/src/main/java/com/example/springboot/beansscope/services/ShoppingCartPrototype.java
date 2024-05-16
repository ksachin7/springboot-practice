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
@Scope("prototype")
//@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartPrototype {
    private final List<Product> cart= new ArrayList<>();
    private static int instanceCounter=0;

    public ShoppingCartPrototype(){
        instanceCounter++;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Prototype bean created. Total instances: " + instanceCounter);
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Prototype bean destroyed. Total instances: "+ (--instanceCounter));
    }

    public void addToCart(Product product){
        cart.add(product);
    }

}

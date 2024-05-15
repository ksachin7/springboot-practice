package com.example.springboot.beansscope.services;

import com.example.springboot.beansscope.beans.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class ShoppingCartSingleton {
    private List<Product> cart= new ArrayList<>();

    public void addToCart(Product product){
        addToCart(product);
    }

    public List<Product> getCart(){
        return cart;
    }
}

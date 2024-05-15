package com.example.springboot.beansscope.services;

import com.example.springboot.beansscope.beans.Product;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
@Scope("prototype")
public class ShoppingCartPrototype {
    private List<Product> cart= new ArrayList<>();

    public void addToCart(Product product){
        cart.add(product);
    }

}

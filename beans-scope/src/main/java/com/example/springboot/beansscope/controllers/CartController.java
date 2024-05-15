package com.example.springboot.beansscope.controllers;

import com.example.springboot.beansscope.beans.Product;
import com.example.springboot.beansscope.services.ShoppingCartPrototype;
import com.example.springboot.beansscope.services.ShoppingCartSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ShoppingCartSingleton singletonCart;

    @Autowired
    private ShoppingCartPrototype prototypeCart;
    private Product product;

    @GetMapping("/singleton")
    public List<Product> getSingletonCart(){
        return singletonCart.getCart();
    }

    @GetMapping("/prototype")
    public List<Product> getPrototypeCart(){
        return prototypeCart.getCart();
    }

    @PostMapping("/singleton/add")
    public String addToSingletonCart(@RequestBody Product product){
        singletonCart.addToCart(product);
        return "Product added to singleton cart: "+product.getName();
    }

    @PostMapping("/prototype/add")
    public String addToPrototypeCart(@RequestBody Product product){
        prototypeCart.addToCart(new Product());
        return "Product added to Prototype Cart: " + product.getName();
    }

}

package com.example.springboot.beansscope.controllers;

import com.example.springboot.beansscope.beans.Product;
import com.example.springboot.beansscope.services.*;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

//    @Autowired
    private ShoppingCartSingleton singletonCart;

//    @Autowired
    private ObjectFactory<ShoppingCartPrototype> prototypeCartFactory;

//    @Autowired
    private ShoppingCartPrototype prototypeCart;

//    @Autowired
    private ShoppingCartSession sessionCart;

//    @Autowired
    private ShoppingCartRequest requestCart;

//    @Autowired
    private final ShoppingCartApplication applicationCart;

    /**
     * Using Constructor injection because field injection is not recommended.
     */
    @Autowired
    public CartController(ShoppingCartApplication applicationCart, ShoppingCartRequest requestCart, ShoppingCartSession sessionCart, ShoppingCartPrototype prototypeCart, ObjectFactory<ShoppingCartPrototype> prototypeCartFactory, ShoppingCartSingleton singletonCart) {
        this.applicationCart = applicationCart;
        this.requestCart = requestCart;
        this.sessionCart = sessionCart;
        this.prototypeCart = prototypeCart;
        this.prototypeCartFactory = prototypeCartFactory;
        this.singletonCart = singletonCart;
    }

    @GetMapping("/singleton")
    public List<Product> getSingletonCart() {
        return singletonCart.getCart();
    }

    /**
     * Retrieve the cart associated with the Prototype scope.<br>
     * <b>Note:</b> Using ObjectFactory to create a new instance of ShoppingCartPrototype per request.
     *  as prototype-scoped beans are not managed directly by the Spring container and need to be instantiated dynamically.
     */
    @GetMapping("/prototype")
    public List<Product> getPrototypeCart() {
        ShoppingCartPrototype prototypeCart = prototypeCartFactory.getObject();
        return prototypeCart.getCart();
    }

    @GetMapping("/session")
    public List<Product> getSessionCart() {
        return sessionCart.getCart();
    }

    @GetMapping("/request")
    public List<Product> getRequestCart() {
        return requestCart.getCart();
    }

    @GetMapping("/application")
    public List<Product> getApplicationCart() {
        return applicationCart.getCart();
    }

    @PostMapping("/singleton/add")
    public String addToSingletonCart(@RequestBody Product product) {
        singletonCart.addToCart(product);
        return "Product added to singleton cart: " + product.getName();
    }

    @PostMapping("/prototype/add")
    public String addToPrototypeCart(@RequestBody Product product) {
        ShoppingCartPrototype prototypeCart = prototypeCartFactory.getObject();
        prototypeCart.addToCart(product);
        return "Product added to Prototype Cart: " + product.getName();
    }

    @PostMapping("/session/add")
    public String addToSessionCart(@RequestBody Product product) {
        sessionCart.addToCart(product);
        return "Product added to Session Cart: " + product.getName();
    }

    @PostMapping("/request/add")
    public String addToRequestCart(@RequestBody Product product) {
        requestCart.addToCart(product);
        return "Product added to Request Cart: " + product.getName();
    }

    @PostMapping("/application/add")
    public String addToApplicationCart(@RequestBody Product product) {
        applicationCart.addToCart(product);
        return "Product added to Application Cart: " + product.getName();
    }
}

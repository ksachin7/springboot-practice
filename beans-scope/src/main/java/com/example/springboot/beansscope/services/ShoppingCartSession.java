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

/**
 * Represents a shopping cart that is scoped to the HTTP session.
 * <p>
 * - This class manages a list of products specific to each user session.<br>
 * - The bean is created once per session and destroyed when the session ends.<br>
 * - When a bean with a wider scope (such as session scope) is injected into a bean with a narrower scope (such as singleton scope),
 *   Spring needs to create a proxy to manage the scoped bean's lifecycle correctly.<br>
 * - The TARGET_CLASS mode indicates that Spring should use class-based proxies to manage the scoped bean.<br>
 * - This ensures that each injection point receives a separate instance of the scoped bean,
 *   maintaining the integrity of the scoped bean's state.
 */
@Getter
@Component
//@Scope("session")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartSession {
    // Counter to track the total number of instances created
    private static int instanceCounter = 0;

    // List to store products in the shopping cart
    private final List<Product> cart = new ArrayList<>();

    /**
     * Default constructor.
     * <p>
     * Increments the instance counter each time a new instance is created.
     */
    public ShoppingCartSession() {
        instanceCounter++;
    }

    /**
     * Method executed after the bean is constructed.
     * <p>
     * Prints a message indicating the creation of a new instance.
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("Session bean created. Total instances: " + instanceCounter);
    }

    /**
     * Method executed before the bean is destroyed.
     * <p>
     * Prints a message indicating the destruction of an instance.
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("Session bean destroyed. Total instances: " + (--instanceCounter));
    }

    /**
     * Adds a product to the shopping cart.
     *
     * @param product The product to add to the shopping cart.
     */
    public void addToCart(Product product) {
        cart.add(product);
    }
}

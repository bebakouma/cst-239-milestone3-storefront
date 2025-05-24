package edu.gcu.storefront.service;

import edu.gcu.storefront.model.SalableProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the user's shopping cart, allowing items to be added, removed, and viewed.
 */
public class ShoppingCart {

    /** The list of items currently in the shopping cart. */
    private final List<SalableProduct> cartItems = new ArrayList<>();

    /**
     * Adds an item to the shopping cart.
     *
     * @param product the product to add
     */
    public void addItem(SalableProduct product) {
        cartItems.add(product);
    }

    /**
     * Removes an item from the shopping cart.
     *
     * @param product the product to remove
     */
    public void removeItem(SalableProduct product) {
        cartItems.remove(product);
    }

    /**
     * Empties the shopping cart.
     */
    public void emptyCart() {
        cartItems.clear();
    }

    /**
     * Returns the list of items in the cart.
     *
     * @return a list of salable products
     */
    public List<SalableProduct> getCartItems() {
        return cartItems;
    }
}

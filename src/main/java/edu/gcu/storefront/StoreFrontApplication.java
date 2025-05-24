package edu.gcu.storefront;

import edu.gcu.storefront.model.SalableProduct;
import edu.gcu.storefront.service.InventoryManager;
import edu.gcu.storefront.service.ShoppingCart;

import java.util.Map;
import java.util.Scanner;

/**
 * Console-based store front application for the GCU Adventure Store.
 */
public class StoreFrontApplication {

    private static final Scanner in = new Scanner(System.in);
    private static final InventoryManager manager = new InventoryManager();
    private static final ShoppingCart cart = new ShoppingCart();

    public static void main(String[] args) {
        System.out.println("=== Welcome to the GCU Adventure Store ===");

        boolean running = true;
        while (running) {
            printMenu();
            switch (in.nextLine().trim()) {
                case "1": listProducts(); break;
                case "2": handleBuy(); break;
                case "3": handleCancel(); break;
                case "4": viewCart(); break;
                case "5": emptyCart(); break;
                case "6": running = false; break;
                default: System.out.println("Invalid choice. Try again.\n");
            }
        }

        System.out.println("Thanks for visiting. Goodbye!");
    }

    private static void printMenu() {
        System.out.println("Please choose an option:\n" +
                "1) List Products\n" +
                "2) Buy Product\n" +
                "3) Cancel Purchase\n" +
                "4) View Cart\n" +
                "5) Empty Cart\n" +
                "6) Exit\n");
        System.out.print("> ");
    }

    private static void listProducts() {
        for (Map.Entry<Integer, SalableProduct> entry : manager.list()) {
            System.out.printf("%d) %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    private static void handleBuy() {
        try {
            System.out.print("Enter product ID to buy: ");
            int id = Integer.parseInt(in.nextLine());
            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(in.nextLine());

            SalableProduct product = manager.getProductById(id);
            manager.buy(id, qty);

            // Add to cart
            cart.addItem(product);

            System.out.println("Purchase successful!\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    private static void handleCancel() {
        try {
            System.out.print("Enter product ID to cancel: ");
            int id = Integer.parseInt(in.nextLine());
            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(in.nextLine());

            SalableProduct product = manager.getProductById(id);
            manager.cancel(id, qty);

            // Remove from cart
            cart.removeItem(product);

            System.out.println("Cancellation successful!\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    private static void viewCart() {
        if (cart.getCartItems().isEmpty()) {
            System.out.println("Your cart is empty.\n");
        } else {
            System.out.println("Your Shopping Cart:");
            cart.getCartItems().forEach(item -> System.out.println("- " + item));
            System.out.println();
        }
    }

    private static void emptyCart() {
        cart.emptyCart();
        System.out.println("Cart emptied.\n");
    }
}

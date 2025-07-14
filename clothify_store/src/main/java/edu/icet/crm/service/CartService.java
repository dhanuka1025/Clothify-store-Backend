package edu.icet.crm.service;

import edu.icet.crm.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private List<Product> cart = new ArrayList<>();

    public List<Product> getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public void removeFromCart(Long productId) {
        cart.removeIf(product -> product.getId().equals(productId));
    }

    public void clearCart() {
        cart.clear();
    }
}
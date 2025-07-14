package edu.icet.crm.controller;


import edu.icet.crm.model.Product;
import edu.icet.crm.entity.ProductEntity;
import edu.icet.crm.repository.ProductRepository;
import edu.icet.crm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class EcommerceController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartService cartService;

    @GetMapping("/products")
    public Iterable<ProductEntity> getAllProducts(@RequestParam(required = false) String category) {
        Iterable<ProductEntity> products = productRepository.findAll();
        if (category != null) {
            return products.forEach()
                    .filter(product -> product.getCategory().equals(category))
                    .collect(Collectors.toList());
        }
        return products;
    }

    @PostMapping("/admin/products")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/admin/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping("/admin/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/cart")
    public List<Product> getCart() {
        return cartService.getCart();
    }

    @PostMapping("/cart")
    public List<Product> addToCart(@RequestBody Product product) {
        cartService.addToCart(product);
        return cartService.getCart();
    }

    @DeleteMapping("/cart/{productId}")
    public List<Product> removeFromCart(@PathVariable Long productId) {
        cartService.removeFromCart(productId);
        return cartService.getCart();
    }

    @DeleteMapping("/cart")
    public void clearCart() {
        cartService.clearCart();
    }
}

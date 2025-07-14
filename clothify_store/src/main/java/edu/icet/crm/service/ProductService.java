package edu.icet.crm.service;

import edu.icet.crm.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> getAllProducts();

    void deleteProduct(Integer Id);
}

package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.dto.Product;
import edu.icet.crm.entity.ProductEntity;
import edu.icet.crm.repository.ProductRepository;
import edu.icet.crm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper mapper;

    @Override
    public Product save(Product product) {
        return mapper.convertValue(productRepository.save(mapper.convertValue(product, ProductEntity.class)), Product.class);
    }

    @Override
    public List<Product> getAllProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productEntity -> {
            productList.add(mapper.convertValue(productEntity, Product.class));
        });
        return productList;
    }

    @Override
    public void deleteProduct(Integer Id) {
        productRepository.deleteById(Id);
    }
}

package edu.icet.crm.controller;

import edu.icet.crm.dto.Product;
import edu.icet.crm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping("add-product")
    Product saveProduct( @RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("get-all-products")
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("delete-product")
    public void deleteProduct(@PathVariable Integer Id){
        productService.deleteProduct(Id);
    }
}

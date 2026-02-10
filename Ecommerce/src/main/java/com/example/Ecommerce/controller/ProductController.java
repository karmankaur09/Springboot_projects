package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    public ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductbyId(@PathVariable int id){
        Product product = productService.getProductbyId(id);
        return product;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product productFromPostman){
       Product responseFromService = productService.addProduct(productFromPostman);
       return responseFromService;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product updateProductFromPostman){
        Product responseFromService= productService.updateProduct(id, updateProductFromPostman );
        return responseFromService;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
}

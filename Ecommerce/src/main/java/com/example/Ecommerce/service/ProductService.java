package com.example.Ecommerce.service;

import com.example.Ecommerce.model.Product;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private RestTemplate restTemplate;
    public ProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public List<Product> getAllProduct(){
        Product[] productList = restTemplate.getForObject("https://fakestoreapi.com/products", Product[].class);
        return Arrays.asList(productList);
    }

    public Product getProductbyId(int id){
        Product productResponseFromFakestore = restTemplate.getForObject("https://fakestoreapi.com/products/{id}", Product.class,id);
        return productResponseFromFakestore;  //sending response to controller from service
    }

    public Product addProduct(Product productFromContoller){
        Product postResponseFromFS = restTemplate.postForObject("https://fakestoreapi.com/products", productFromContoller, Product.class);
        return postResponseFromFS;
    }

//    public void updateProduct(int id, Product updateproductFromController){
//        restTemplate.put("https://fakestoreapi.com/products/{id}", updateproductFromController,id);
//    }

    public Product updateProduct(int id, Product updateproductFromController){
        HttpHeaders headers = new HttpHeaders();      //header object created
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Product> requestEntity = new HttpEntity<>(updateproductFromController, headers);

        ResponseEntity<Product> response = restTemplate.exchange(
                "https://fakestoreapi.com/products/{id}",
                HttpMethod.PUT,
                requestEntity,
                Product.class,
                id );
        return response.getBody();
    }

    public void deleteProduct(int id){
        restTemplate.delete("https://fakestoreapi.com/products/{id}", id);
    }
}



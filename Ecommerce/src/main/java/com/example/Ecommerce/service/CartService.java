package com.example.Ecommerce.service;

import com.example.Ecommerce.model.Carts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private RestTemplate rt;
    public List<Carts> getAllCartsFromFS(){
        Carts[] cartReceivedFromFS = rt.getForObject("https://fakestoreapi.com/carts", Carts[].class);
        return List.of(cartReceivedFromFS);
    }
    public Carts getCartbyidFromFS(int CartId){
        Carts cartByIdReceivedFromFS = rt.getForObject("https://fakestoreapi.com/carts/{id}", Carts.class,CartId);
        return cartByIdReceivedFromFS;
    }
    public Carts createCartInFakeStore(Carts CartRequestFromController){
        Carts createdCartFromFakeStore  = rt.postForObject("https://fakestoreapi.com/carts",CartRequestFromController,Carts.class);
        return createdCartFromFakeStore;
    }
    public Carts CartsUpdateInFS(int id, Carts responseFromController){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Carts> requestEntity = new HttpEntity<>(responseFromController, headers);
        ResponseEntity<Carts> response = rt.exchange(
                "https://fakestoreapi.com/carts/{id}",
                HttpMethod.PUT,
                requestEntity,
                Carts.class,pwd
                id);
        return response.getBody();

    }


}

package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.Carts;
import com.example.Ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartServiceBean;

    @GetMapping
    public List<Carts> getAllCarts(){
        return cartServiceBean.getAllCartsFromFS();
    }
    @GetMapping ("/{id}")
    public Carts getCartById(@PathVariable int id){
        return cartServiceBean.getCartbyidFromFS(id);
    }
    @PostMapping
    public Carts createCrats(@RequestBody Carts newCartFromClient){
        return cartServiceBean.createCartInFakeStore(newCartFromClient);
    }
    @PutMapping("/{id}")
    public Carts updateCarts(@PathVariable int id, @RequestBody Carts updateCartsFromClient){
        return cartServiceBean.CartsUpdateInFS(id, updateCartsFromClient);
    }
}

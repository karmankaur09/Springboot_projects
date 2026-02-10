package com.example.Ecommerce.service;

import com.example.Ecommerce.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;
//    public UserService (RestTemplate restTemplate){
//        this.restTemplate = restTemplate;
//    }
    public List<Users> getAllUsersFromFS(){
        Users[] listUsersFromFS = restTemplate.getForObject("https://fakestoreapi.com/users", Users[].class);
        return List.of(listUsersFromFS);
    }

    public Users getUserbyid(int id){
        Users UserByidFromFS = restTemplate.getForObject("https://fakestoreapi.com/users/{id}",Users.class,id);
        return UserByidFromFS;
    }
    public Users addUser(Users UserFromController){
        Users addUserToFS = restTemplate.postForObject("https://fakestoreapi.com/users",UserFromController ,Users.class);
        return addUserToFS;
    }

    public Users updateUsers(int id, Users responseFromController){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Users> requestEntity = new HttpEntity<>(responseFromController, headers);

        ResponseEntity<Users> response = restTemplate.exchange(
                "https://fakestoreapi.com/users/{id}",
                HttpMethod.PUT,
                requestEntity,
                Users.class,
                id);
        return response.getBody();
    }

    public void deleteUser(int id){
        restTemplate.delete("https://fakestoreapi.com/users/{id}", id);
    }
}

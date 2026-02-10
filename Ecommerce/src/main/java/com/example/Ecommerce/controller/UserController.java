package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.Users;
import com.example.Ecommerce.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    public UserService userService;
    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAllUsersFromFS();
    }
    @GetMapping ("/{id}")
        public Users getUserbyId(@PathVariable int id){
        Users usersFromService =userService.getUserbyid(id);
        return usersFromService;
    }

    @PostMapping
    public Users addUsers(@RequestBody Users addingUser){
        Users addedUserFromService= userService.addUser(addingUser);
        return addedUserFromService;
    }

    @PutMapping("/{id}")
    public Users updateUsers(@PathVariable int id, @RequestBody Users requestFromPostman){
        Users updateUsersFromService = userService.updateUsers(id, requestFromPostman);
        return updateUsersFromService;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}

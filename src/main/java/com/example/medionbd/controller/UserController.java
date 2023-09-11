package com.example.medionbd.controller;

import com.example.medionbd.model.User;
import com.example.medionbd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path="/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public  UserController(UserService userService){
        this.userService= userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return  userService.getUsers();
    }

    @PostMapping
    public void createUser(User user){
        userService.createUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") UUID userId){
        userService.deleteUser(userId);
    }
    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") UUID userId,
            @RequestBody User updatedUser
    ){
        userService.updateUser(userId,updatedUser);
    }
}

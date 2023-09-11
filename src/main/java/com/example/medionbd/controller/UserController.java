package com.example.medionbd.controller;

import com.example.medionbd.dto.UserDto;
import com.example.medionbd.model.User;
import com.example.medionbd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path="/api/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public  UserController(UserService userService){
        this.userService= userService;
    }

    @RequestMapping(value = "/users/all" , method = RequestMethod.GET)
    public @ResponseBody  List<User> getAllUsers(){
        return  userService.getAllUsers();
    }

    @RequestMapping(value = "/user" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
         User createdUser= userService.createUser(userDto);
         return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/{userId}" , method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("userId") UUID userId){
        userService.deleteUser(userId);
    }
    @RequestMapping(value = "/users/{userId}" , method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<User> updateUser(
            @PathVariable("userId") UUID userId,
            @RequestBody UserDto updatedUserDto
    ){
        User updatedUser = userService.updateUser(userId, updatedUserDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}

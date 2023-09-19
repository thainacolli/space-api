package com.spaceapi.controllers;

import com.spaceapi.DTOS.AnimeDTO;
import com.spaceapi.DTOS.UserDTO;
import com.spaceapi.models.UserModel;
import com.spaceapi.services.AnimeServices;
import com.spaceapi.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class userController {
    @Autowired
    private UserServices services;

    @PostMapping("/addUser")
    public ResponseEntity createUser(@RequestBody UserModel user){
        ResponseEntity response = services.saveUser(user);
        return response;
    }

    @GetMapping("/list")
    public ResponseEntity getAllUsers(){
        return services.getAllUsers();
    }

}

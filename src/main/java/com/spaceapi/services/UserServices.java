package com.spaceapi.services;

import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.DTOS.UserDTO;
import com.spaceapi.models.MovieModel;
import com.spaceapi.models.UserModel;
import com.spaceapi.repositories.UserRepositories;
import com.spaceapi.utils.Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepositories repository;

    public ResponseEntity saveUser(UserModel user) {
        try {
            UserModel newUser = new UserModel();
            Crypt crip = new Crypt();
            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());
            newUser.setPassword(crip.encrpt(user.getPassword()));
            newUser.setRole(user.getRole());

            Optional<UserModel> userResult = Optional.ofNullable(repository.save(newUser));

            if (userResult.isPresent()) {
                return ResponseEntity.status(200).body(userResult);
            } else {
                return ResponseEntity.status(500).body(userResult);
            }

        } catch (Error e) {
            return ResponseEntity.status(500).body(e);
        }

    }

    public ResponseEntity getAllUsers(){
        List<UserModel> users = repository.findAll();
        return ResponseEntity.status(200).body(users);
    }
}

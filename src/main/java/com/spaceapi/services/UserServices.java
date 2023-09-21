package com.spaceapi.services;

import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.DTOS.UserDTO;
import com.spaceapi.models.MovieModel;
import com.spaceapi.models.UserModel;
import com.spaceapi.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepositories repository;

    public ResponseEntity saveUser(UserDTO user) {
        try {
            UserModel newUser = new UserModel();
            newUser.setEmail(user.email());
            newUser.setName(user.name());
            newUser.setPassword(user.password());
            newUser.setRole(user.roles());

            Optional<UserModel> userResult = Optional.ofNullable(repository.save(newUser));

            if (userResult.isPresent()) {
                return ResponseEntity.status(201).body(userResult);
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

    public UserModel findById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Usuario nao encontrado"));
    }
}

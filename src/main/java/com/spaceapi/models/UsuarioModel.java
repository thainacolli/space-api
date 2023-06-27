package com.spaceapi.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class UsuarioModel {
    @Id
    String id;
    String name;
    String password;
}

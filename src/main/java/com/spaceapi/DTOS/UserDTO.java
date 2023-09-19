package com.spaceapi.DTOS;

import com.spaceapi.ENUMS.RolesENUM;

public record UserDTO(String email, String password, String name, RolesENUM roles) {
}

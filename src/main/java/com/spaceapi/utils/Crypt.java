package com.spaceapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Crypt {
    public String encrpt(String password){
        BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
        String encoder = encrypt.encode(password);
        return encoder;
    }

    private boolean comparePass(String newpass,String pass){
        BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
        return encrypt.matches(newpass,pass);
    }

}

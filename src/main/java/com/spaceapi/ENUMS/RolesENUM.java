package com.spaceapi.ENUMS;

public enum RolesENUM {
    ADM,
    USER;

    private String role;

    void RolesEnum(String role){
        this.role = role;
    }

    public String RolesEnum(){
        return this.role;
    }
}

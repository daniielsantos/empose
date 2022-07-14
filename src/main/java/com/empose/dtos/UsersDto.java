package com.empose.dtos;


import com.empose.models.Sku;

import javax.validation.constraints.NotEmpty;

public class UsersDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    public UsersDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UsersDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

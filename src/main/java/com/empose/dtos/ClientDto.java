package com.empose.dtos;


import com.empose.models.ClientAddress;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientDto {

    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String email;
    @NotEmpty
    @NotNull
    private String cpf;
    @NotEmpty
    @NotNull
    private String phoneNumber;
//    @NotEmpty
//    @NotNull
    private ClientAddress address;

    public ClientDto(String name, String email, String cpf, String phoneNumber, ClientAddress address) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public ClientDto() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ClientAddress getAddress() {
        return address;
    }

    public void setAddress(ClientAddress address) {
        this.address = address;
    }
}

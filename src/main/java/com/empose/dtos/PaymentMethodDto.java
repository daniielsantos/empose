package com.empose.dtos;


import com.empose.models.PaymentMethods;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PaymentMethodDto {

    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String description;

    public PaymentMethodDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public PaymentMethodDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentMethods toPaymentMethod(PaymentMethodDto paymentMethodDto) {
        PaymentMethods paymentMethods = new PaymentMethods();
        paymentMethods.setName(paymentMethodDto.getName());
        paymentMethods.setDescription(paymentMethodDto.getDescription());
        return paymentMethods;
    }

    @Override
    public String toString() {
        return "PaymentMethodDto{" +
                "name='" + name + '\'' +
                ", desc='" + description + '\'' +
                '}';
    }
}

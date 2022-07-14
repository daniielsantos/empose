package com.empose.dtos;


import com.empose.models.Sku;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class SkuDto {

    @NotEmpty
    private Sku sku;


    public SkuDto(Sku sku) {
        this.sku = sku;
    }

    public SkuDto() {
    }


    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }


    @Override
    public String toString() {
        return "SkuDto{" +
                "sku=" + sku +
                '}';
    }
}

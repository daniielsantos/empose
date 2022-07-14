package com.empose.dtos;


import com.empose.models.Sku;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductSkuDto {

//    @NotEmpty
    @NotNull
    private Integer product_id;
    @NotEmpty
    private List<Sku> skus = new ArrayList<>();

    public ProductSkuDto(Integer product_id, List<Sku> skus) {
        this.product_id = product_id;
        this.skus = skus;
    }

    public ProductSkuDto() {
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }
}

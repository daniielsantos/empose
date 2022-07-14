package com.empose.dtos;


import com.empose.models.Category;
import com.empose.models.PaymentMethods;
import com.empose.models.Sku;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductDto {

    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String description;
    private BigDecimal price;
    private Boolean status;
    private Float discount;
    private List<Sku> skus = new ArrayList<>();
    private Category category;

    public ProductDto(String name, String description, BigDecimal price, Boolean status, Float discount, List<Sku> skus, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
        this.discount = discount;
        this.skus = skus;
        this.category = category;
    }

    public ProductDto() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", discount=" + discount +
                '}';
    }
}

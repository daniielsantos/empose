package com.empose.dtos;


import com.empose.models.Sku;

import javax.validation.constraints.NotEmpty;

public class CategoryDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private String description;


    public CategoryDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryDto() {
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
}

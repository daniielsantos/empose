package com.empose.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Sku implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Boolean isActive;
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
    @OneToOne
    @JoinColumn(name = "sku_id")
    private OrderItem orderItem;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Sku(String name, String description, Boolean isActive, Product product) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.product = product;
    }

    public Sku() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }



    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}


package com.empose.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Sku sku;
    private Integer quantity;

    public Inventory(Sku sku, Integer quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public Inventory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}


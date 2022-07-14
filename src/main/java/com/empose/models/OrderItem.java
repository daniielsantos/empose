package com.empose.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;
    @OneToOne()
    @JoinColumn(name = "sku_id")
    private Sku sku;
    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order orders;

    public OrderItem(int quantity, Order orders) {
        this.quantity = quantity;
        this.orders = orders;
    }

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", sku=" + sku +
                '}';
    }
}

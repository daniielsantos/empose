package com.empose.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;


@Entity
@Table(name="orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal total;
    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethods paymentMethod;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items = new ArrayList<>();
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Order(BigDecimal total, PaymentMethods paymentMethod, Client client, List<OrderItem> items) {
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.client = client;
        this.items = items;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}

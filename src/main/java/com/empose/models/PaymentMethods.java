package com.empose.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table()
public class PaymentMethods implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @OneToMany()
    @JoinColumn(name = "payment_method_id")
    private List<Order> order;

    public PaymentMethods(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public PaymentMethods() {
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


    @Override
    public String toString() {
        return "PaymentMethods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", order=" + order +
                '}';
    }
}

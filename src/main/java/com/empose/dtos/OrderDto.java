package com.empose.dtos;


import com.empose.models.Client;
import com.empose.models.ClientAddress;
import com.empose.models.OrderItem;
import com.empose.models.PaymentMethods;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class OrderDto {

//    @NotEmpty
//    @NotNull
    private BigDecimal total;
//    @NotEmpty
//    @NotNull
    private PaymentMethods paymentMethod;
//    @NotEmpty
//    @NotNull
    private Client client;

    @NotEmpty
    @NotNull
    private List<OrderItem> items;

    public OrderDto(BigDecimal total, PaymentMethods paymentMethod, Client client, List<OrderItem> items) {
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.client = client;
        this.items = items;
    }

    public OrderDto() {
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

    @Override
    public String toString() {
        return "OrderDto{" +
                "total=" + total +
                ", paymentMethod=" + paymentMethod +
                ", client=" + client +
                ", items=" + items +
                '}';
    }
}

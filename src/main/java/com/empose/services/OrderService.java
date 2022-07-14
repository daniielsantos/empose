package com.empose.services;

import com.empose.models.Order;
import com.empose.models.PaymentMethods;
import com.empose.repositories.OrderRepository;
import com.empose.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order save(Order order) {
//        Optional<PaymentMethods> optClient = orderRepository.findByName(order.getName());
//        if (!optClient.isPresent()) {
            return orderRepository.save(order);
//        }
//        return new PaymentMethods();
    }

    public Order update(Order order) {
        Optional<Order> optPayment = orderRepository.findById(order.getId());
        Order paymentMethodtUpdate = new Order();

        if (optPayment.isPresent()) {
            paymentMethodtUpdate = orderRepository.save(order);
        }

        return paymentMethodtUpdate;
    }

    public String remove(Order order) {
        Optional<Order> optPayment = orderRepository.findById(order.getId());

        if (optPayment.isPresent()) {
            orderRepository.delete(order);
                return "";
            } else {
                return "Metodo de pagamento não pode ser removido.";
            }
    }
}

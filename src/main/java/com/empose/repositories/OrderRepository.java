package com.empose.repositories;

import com.empose.models.Order;
import com.empose.models.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
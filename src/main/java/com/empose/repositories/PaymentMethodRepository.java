package com.empose.repositories;

import com.empose.models.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethods, Integer> {

    Optional<PaymentMethods> findByName(String name);
}
package com.empose.repositories;

import com.empose.models.PaymentMethods;
import com.empose.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);
}
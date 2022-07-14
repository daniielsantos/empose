package com.empose.repositories;

import com.empose.models.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkuRepository extends JpaRepository<Sku, Integer> {

    Optional<Sku> findByName(String name);
}
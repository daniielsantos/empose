package com.empose.repositories;

import com.empose.models.Category;
import com.empose.models.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByName(String name);
}
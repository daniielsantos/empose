package com.empose.repositories;

import com.empose.models.Inventory;
import com.empose.models.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

}
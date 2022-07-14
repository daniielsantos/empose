package com.empose.services;

import com.empose.models.Inventory;
import com.empose.models.Sku;
import com.empose.repositories.InventoryRepository;
import com.empose.repositories.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Optional<Inventory> findById(Integer id) {
        return inventoryRepository.findById(id);
    }

    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    public Inventory save(Inventory inventory) {
        Optional<Inventory> optClient = inventoryRepository.findById(inventory.getId());

        if (!optClient.isPresent()) {
            return inventoryRepository.save(inventory);
        }
        return new Inventory();
    }

    public Inventory update(Inventory inventory) {
        Optional<Inventory> optPayment = inventoryRepository.findById(inventory.getId());
        Inventory skuUpdated = new Inventory();

        if (optPayment.isPresent()) {
            skuUpdated = inventoryRepository.save(inventory);
        }
        return skuUpdated;
    }

    public String remove(Inventory inventory) {
        Optional<Inventory> optPayment = inventoryRepository.findById(inventory.getId());

        if (optPayment.isPresent()) {
            inventoryRepository.delete(inventory);
                return "";
            } else {
                return "Inventory não pode ser removido.";
            }
    }
}

package com.empose.services;

import com.empose.models.Product;
import com.empose.models.Sku;
import com.empose.repositories.ProductRepository;
import com.empose.repositories.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkuService {

    @Autowired
    private SkuRepository skuRepository;

    public Optional<Sku> findById(Integer id) {
        return skuRepository.findById(id);
    }

    public List<Sku> findAll() {
        return skuRepository.findAll();
    }

    public Sku save(Sku sku) {
        Optional<Sku> optClient = skuRepository.findByName(sku.getName());

        if (!optClient.isPresent()) {
            return skuRepository.save(sku);
        }
        return new Sku();
    }

    public Sku update(Sku sku) {
        Optional<Sku> optPayment = skuRepository.findById(sku.getId());
        Sku skuUpdated = new Sku();

        if (optPayment.isPresent()) {
            skuUpdated = skuRepository.save(sku);
        }
        return skuUpdated;
    }

    public String remove(Sku sku) {
        Optional<Sku> optPayment = skuRepository.findById(sku.getId());

        if (optPayment.isPresent()) {
            skuRepository.delete(sku);
                return "";
            } else {
                return "Sku não pode ser removido.";
            }
    }
}

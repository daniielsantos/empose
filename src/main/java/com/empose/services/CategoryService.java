package com.empose.services;

import com.empose.models.Category;
import com.empose.models.Sku;
import com.empose.repositories.CategoryRepository;
import com.empose.repositories.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) {
        Optional<Category> optClient = categoryRepository.findByName(category.getName());

        if (!optClient.isPresent()) {
            return categoryRepository.save(category);
        }
        return new Category();
    }

    public Category update(Category category) {
        Optional<Category> optPayment = categoryRepository.findById(category.getId());
        Category skuUpdated = new Category();

        if (optPayment.isPresent()) {
            skuUpdated = categoryRepository.save(category);
        }
        return skuUpdated;
    }

    public String remove(Category category) {
        Optional<Category> optPayment = categoryRepository.findById(category.getId());

        if (optPayment.isPresent()) {
            categoryRepository.delete(category);
                return "";
            } else {
                return "Sku não pode ser removido.";
            }
    }
}

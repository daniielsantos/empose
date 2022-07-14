package com.empose.services;

import com.empose.models.PaymentMethods;
import com.empose.models.Product;
import com.empose.repositories.PaymentMethodRepository;
import com.empose.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        Optional<Product> optClient = productRepository.findByName(product.getName());

        if (!optClient.isPresent()) {
            return productRepository.save(product);
        }
        return new Product();
    }

    public Product update(Product product) {
        Optional<Product> optPayment = productRepository.findById(product.getId());
        Product paymentMethodtUpdate = new Product();

        if (optPayment.isPresent()) {
            paymentMethodtUpdate = productRepository.save(product);
        }
        return paymentMethodtUpdate;
    }

    public String remove(Product product) {
        Optional<Product> optPayment = productRepository.findById(product.getId());

        if (optPayment.isPresent()) {
            productRepository.delete(product);
                return "";
            } else {
                return "Produto não pode ser removido.";
            }
    }
}

package com.empose.controllers;

import com.empose.dtos.PaymentMethodDto;
import com.empose.dtos.ProductDto;
import com.empose.dtos.ProductSkuDto;
import com.empose.models.Inventory;
import com.empose.models.PaymentMethods;
import com.empose.models.Product;
import com.empose.models.Sku;
import com.empose.repositories.InventoryRepository;
import com.empose.repositories.SkuRepository;
import com.empose.responses.ErrorResponse;
import com.empose.services.InventoryService;
import com.empose.services.PaymentMethodService;
import com.empose.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private SkuRepository skuRepository;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }
    @PostMapping("/sku")
    public ResponseEntity<?> saveSku(@RequestBody @Valid ProductSkuDto productSkuDto) {
        Optional<Product> prod = productService.findById(productSkuDto.getProduct_id());
        if (prod.isPresent()) {
            Product product = prod.get();
            List<Inventory> listInventory = new ArrayList<>();
            for (Sku sk : productSkuDto.getSkus()) {
                sk.setProduct(product);
                Inventory inventory = new Inventory();
                inventory.setSku(sk);
                inventory.setQuantity(0);
                listInventory.add(inventory);
            }

            skuRepository.saveAll(productSkuDto.getSkus());
            productService.save(product);
            inventoryRepository.saveAll(listInventory);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("Produto nao encontrado."), HttpStatus.NOT_FOUND);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Valid ProductDto productDto) {
        Product paymentMethods = new Product();
        BeanUtils.copyProperties(productDto, paymentMethods);
        Product prod = productService.save(paymentMethods);
        if (prod.getId() != null) {
            return new ResponseEntity<>(prod, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("Metodo de pagamento ja existe."), HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Product product) {
        Product paymentMethodSave = productService.update(product);
        if (paymentMethodSave.getId() != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Produto não encontrado,"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Product product) {
        String returnMessage = productService.remove(product);

        if (returnMessage.equals(""))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(new ErrorResponse(returnMessage), HttpStatus.NOT_ACCEPTABLE);
    }

}
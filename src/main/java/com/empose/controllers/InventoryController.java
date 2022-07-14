package com.empose.controllers;

import com.empose.dtos.ProductDto;
import com.empose.models.Inventory;
import com.empose.models.Product;
import com.empose.models.Sku;
import com.empose.responses.ErrorResponse;
import com.empose.services.InventoryService;
import com.empose.services.ProductService;
import com.empose.services.SkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
//    @Autowired
//    private SkuService skuService;

    @GetMapping
    public List<Inventory> findAll() {
        return inventoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(inventoryService.findById(id), HttpStatus.OK);
    }

//    @PostMapping(produces = "application/json")
//    public ResponseEntity<?> save(@RequestBody @Valid ProductDto productDto) {
//        Product paymentMethods = new Product();
//        BeanUtils.copyProperties(productDto, paymentMethods);
//        Product prod = productService.save(paymentMethods);
//        if (prod.getId() != null) {
//            return new ResponseEntity<>(prod, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(new ErrorResponse("Metodo de pagamento ja existe."), HttpStatus.NOT_FOUND);
//    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Inventory inventory) {
        Inventory paymentMethodSave = inventoryService.update(inventory);

        if (paymentMethodSave.getId() != null) {
            return new ResponseEntity<>(inventory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Inventario não encontrado,"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Inventory inventory) {
        String returnMessage = inventoryService.remove(inventory);

        if (returnMessage.equals(""))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(new ErrorResponse(returnMessage), HttpStatus.NOT_ACCEPTABLE);
    }

}
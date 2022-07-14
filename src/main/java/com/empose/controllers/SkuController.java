package com.empose.controllers;

import com.empose.dtos.ProductDto;
import com.empose.dtos.ProductSkuDto;
import com.empose.dtos.SkuDto;
import com.empose.models.Product;
import com.empose.models.Sku;
import com.empose.repositories.SkuRepository;
import com.empose.responses.ErrorResponse;
import com.empose.services.ProductService;
import com.empose.services.SkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/sku")
public class SkuController {

    @Autowired
    private ProductService productService;
    @Autowired
    private SkuService skuService;

    @GetMapping
    public List<Sku> findAll() {
        return skuService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(skuService.findById(id), HttpStatus.OK);
    }
//    @PostMapping("/")
//    public ResponseEntity<?> saveSku(@RequestBody @Valid SkuDto skuDto) {
//        Optional<Product> product = productService.findById(skuDto.getProduct_id());
//
//        if (product.isPresent()) {
//            Sku sku = new Sku();
//            sku = skuDto.getSku();
//            sku.setProduct(product.get());
//            skuService.save(sku);
//            return new ResponseEntity<>(sku, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(new ErrorResponse("Produto nao encontrado."), HttpStatus.NOT_FOUND);
//    }

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
    public ResponseEntity<?> update(@RequestBody Sku sku) {
        Sku paymentMethodSave = skuService.update(sku);

        if (paymentMethodSave.getId() != null) {
            return new ResponseEntity<>(sku, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Sku não encontrado,"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Sku sku) {
        String returnMessage = skuService.remove(sku);

        if (returnMessage.equals(""))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(new ErrorResponse(returnMessage), HttpStatus.NOT_ACCEPTABLE);
    }

}
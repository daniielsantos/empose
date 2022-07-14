package com.empose.controllers;

import com.empose.dtos.ClientDto;
import com.empose.dtos.PaymentMethodDto;
import com.empose.models.Client;
import com.empose.models.ClientAddress;
import com.empose.models.PaymentMethods;
import com.empose.responses.ErrorResponse;
import com.empose.services.ClientService;
import com.empose.services.PaymentMethodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/payment-methods")
public class PaymentMethodsController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public List<PaymentMethods> findAll() {
        return paymentMethodService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(paymentMethodService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Valid PaymentMethodDto paymentMethodDto) {
        PaymentMethods paymentMethods = new PaymentMethods();
        BeanUtils.copyProperties(paymentMethodDto, paymentMethods);
        PaymentMethods payment = paymentMethodService.save(paymentMethods);
        if (payment.getId() != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("Metodo de pagamento ja existe."), HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PaymentMethods paymentMethods) {
        PaymentMethods paymentMethodSave = paymentMethodService.update(paymentMethods);
        if (paymentMethodSave.getId() != null) {
            return new ResponseEntity<>(paymentMethods, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Metodo de pagamento não encontrado,"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody PaymentMethods paymentMethods) {
        String returnMessage = paymentMethodService.remove(paymentMethods);

        if (returnMessage.equals(""))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(new ErrorResponse(returnMessage), HttpStatus.NOT_ACCEPTABLE);
    }

}
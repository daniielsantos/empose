package com.empose.controllers;

import com.empose.dtos.OrderDto;
import com.empose.dtos.PaymentMethodDto;
import com.empose.models.Order;
import com.empose.models.PaymentMethods;
import com.empose.responses.ErrorResponse;
import com.empose.services.OrderService;
import com.empose.services.PaymentMethodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Valid OrderDto orderDto) {

        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        Order savedOrder = orderService.save(order);
        if (savedOrder.getId() != null) {
            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("Pedido ja existe."), HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Order order) {
        Order orderSave = orderService.update(order);
        if (orderSave.getId() != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Pedido não encontrado,"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Order order) {
        String returnMessage = orderService.remove(order);

        if (returnMessage.equals(""))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(new ErrorResponse(returnMessage), HttpStatus.NOT_ACCEPTABLE);
    }

}
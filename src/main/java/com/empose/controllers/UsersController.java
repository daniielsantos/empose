package com.empose.controllers;

import com.empose.dtos.UsersDto;
import com.empose.models.Sku;
import com.empose.models.Users;
import com.empose.responses.ErrorResponse;
import com.empose.services.ProductService;
import com.empose.services.SkuService;
import com.empose.services.UsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {

    @Autowired
    private UsersService usersService;
//    @Autowired
//    private SkuService skuService;

    @GetMapping
    public List<Users> findAll() {
        return usersService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(usersService.findById(id), HttpStatus.OK);
    }


    @PostMapping(produces = "application/json")
    public ResponseEntity<?> save(@RequestBody UsersDto usersDto) {
        Users users = new Users();
        BeanUtils.copyProperties(usersDto, users);
        Users prod = usersService.save(users);
        if (prod.getId() != null) {
            return new ResponseEntity<>(prod, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("Usuarioja existe."), HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Users users) {
        Users paymentMethodSave = usersService.update(users);

        if (paymentMethodSave.getId() != null) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Usuario não encontrado,"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Users users) {
        String returnMessage = usersService.remove(users);

        if (returnMessage.equals(""))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(new ErrorResponse(returnMessage), HttpStatus.NOT_ACCEPTABLE);
    }

}
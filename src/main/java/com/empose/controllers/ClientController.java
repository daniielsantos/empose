package com.empose.controllers;

import com.empose.dtos.ClientDto;
import com.empose.models.Client;
import com.empose.models.ClientAddress;
import com.empose.responses.ErrorResponse;
import com.empose.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Valid ClientDto clientDto) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);

        List<ClientAddress> clientAddresses = new ArrayList<>();
        clientAddresses.add(clientDto.getAddress());
        client.setAddress(clientAddresses);
        Client clientSave = clientService.save(client);

        if (clientSave.getId() != null) {
            return new ResponseEntity<>(clientSave, HttpStatus.OK);
        }

        return new ResponseEntity<>(new ErrorResponse("Já existe um cliente com este CPF."), HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Client client) {
        Client clientSave = clientService.update(client);
        if (clientSave.getId() != null) {
            return new ResponseEntity<>(clientSave, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Cliente não encontrado,"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Client client) {
        String returnMessage = clientService.remove(client);

        if (returnMessage.equals(""))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(new ErrorResponse(returnMessage), HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/search/{text}")
    public List<Client> findByText(@PathVariable(value="text") String text){
        return clientService.findClientByText(text);
    }
}
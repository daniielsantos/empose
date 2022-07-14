package com.empose.controllers;

import com.empose.dtos.EmailSenderDto;
import com.empose.dtos.ProductDto;
import com.empose.models.Product;
import com.empose.responses.ErrorResponse;
import com.empose.services.EmailSenderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/email-sender")

public class EmailSenderController {
    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Valid EmailSenderDto emailSenderDto) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa "+ emailSenderDto.toString());
        emailSenderService.sendEmail(emailSenderDto.getToEmail(),emailSenderDto.getSubject(),emailSenderDto.getBody());

        return new ResponseEntity<>("Email enviado", HttpStatus.OK);
    }
}

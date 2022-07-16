package com.shop24.api.controller;

import com.shop24.api.model.Client;
import com.shop24.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "clients/")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@Validated @RequestBody Client client, HttpServletRequest request){
        clientService.create(client);
        return new ResponseEntity<Object>(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findClient(@PathVariable("id") long id, HttpServletRequest request){
        return new ResponseEntity<Object>(clientService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAl( HttpServletRequest request){
        return new ResponseEntity<Object>(clientService.findAll(), HttpStatus.OK);
    }
}

package com.shop24.api.controller;

import com.shop24.api.model.Cargo;
import com.shop24.api.model.CargoDrink;
import com.shop24.api.service.CargoDrinkService;
import com.shop24.api.service.CargoService;
import com.shop24.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "cargo_drinks/")
public class CargoDrinkController {

    @Autowired
    private CargoDrinkService cargoDrinkService;
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@Validated @RequestBody CargoDrink drink, HttpServletRequest request){
         cargoDrinkService.create(drink);
        return new ResponseEntity<Object>(drink, HttpStatus.OK);
    }


    @RequestMapping(value = "cargo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findCargo(@PathVariable("id") long id, HttpServletRequest request){
        return new ResponseEntity<Object>(cargoDrinkService.findByCargoId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "nearest/clients/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findNearlestCargoDrinks(@PathVariable("id") long id, HttpServletRequest request){
        return new ResponseEntity<Object>(cargoDrinkService.findAvailableNearlestCargoDrink(clientService.findById(id)), HttpStatus.OK);
    }


}

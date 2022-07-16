package com.shop24.api.controller;


import com.shop24.api.model.Cargo;
import com.shop24.api.model.Drink;
import com.shop24.api.service.CargoService;
import com.shop24.api.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "cargo/")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@Validated @RequestBody Cargo cargo, HttpServletRequest request){
        cargoService.create(cargo);
        return new ResponseEntity<Object>(cargo, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findCargo(@PathVariable("id") long id, HttpServletRequest request){
        return new ResponseEntity<Object>(cargoService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAl( HttpServletRequest request){
        return new ResponseEntity<Object>(cargoService.findAll(), HttpStatus.OK);
    }
}

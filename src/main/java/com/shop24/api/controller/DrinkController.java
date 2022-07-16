package com.shop24.api.controller;


import com.shop24.api.model.Client;
import com.shop24.api.model.Drink;
import com.shop24.api.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "drinks/")
public class DrinkController {
    @Autowired
    private DrinkService drinkService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@Validated @RequestBody Drink drink, HttpServletRequest request){
        drinkService.create(drink);
        return new ResponseEntity<Object>(drink, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findDrink(@PathVariable("id") long id, HttpServletRequest request){
        return new ResponseEntity<Object>(drinkService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAl( HttpServletRequest request){
        return new ResponseEntity<Object>(drinkService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/most_consumed/{limit}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findMostConsumed( @PathVariable("limit") int limit,HttpServletRequest request){
        return new ResponseEntity<Object>(drinkService.findMostConsumed(limit), HttpStatus.OK);
    }
}

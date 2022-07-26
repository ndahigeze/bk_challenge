package com.shop24.api.controller;

import com.shop24.api.model.CargoDrink;
import com.shop24.api.model.Client;
import com.shop24.api.service.OrderDrinkService;
import com.shop24.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(path = "order_drinks/")
public class OrderDrinksController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDrinkService orderDrinkService;

    @RequestMapping(value = "/create/{client_id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@PathVariable("client_id")long client_id,@Validated @RequestBody List<Long> cargoDrinksIds, HttpServletRequest request){
        orderDrinkService.create(cargoDrinksIds,client_id);
        return new ResponseEntity<Object>(cargoDrinksIds, HttpStatus.OK);
    }

    @RequestMapping(value = "clients/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findClient(@PathVariable("id") long id, HttpServletRequest request){
        return new ResponseEntity<Object>(orderDrinkService.findByClient(id), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable("id") long id, HttpServletRequest request){
        return new ResponseEntity<Object>(orderDrinkService.findByOrder(id), HttpStatus.OK);
    }


}

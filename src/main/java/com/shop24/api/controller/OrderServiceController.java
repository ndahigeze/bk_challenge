package com.shop24.api.controller;

import com.shop24.api.model.Cargo;
import com.shop24.api.model.Order;
import com.shop24.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "order/")
public class OrderServiceController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@Validated @RequestBody Order order, HttpServletRequest request){
        orderService.create(order);
        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findCargo(@PathVariable("id") long id, HttpServletRequest request){
        return new ResponseEntity<Object>(orderService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "clients/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAl(@PathVariable("id") long id, HttpServletRequest request){
        return new ResponseEntity<Object>(orderService.findByClient(id), HttpStatus.OK);
    }

    @RequestMapping(value = "top_orders/{limit}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findTopOrders(@PathVariable("limit") int limit, HttpServletRequest request){
        return new ResponseEntity<Object>(orderService.topOrders(limit), HttpStatus.OK);
    }

    @RequestMapping(value = "top_paid/{limit}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findTopPaid(@PathVariable("limit") int limit, HttpServletRequest request){
        return new ResponseEntity<Object>(orderService.topPaid(limit), HttpStatus.OK);
    }


}

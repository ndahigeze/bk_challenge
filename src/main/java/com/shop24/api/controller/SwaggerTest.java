package com.shop24.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SwaggerTest {
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<String> getProducts() {
        List<String> productsList = new ArrayList<>();
        productsList.add("Honey");
        productsList.add("Almond");
        return productsList;
    }
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String createProduct() {
        return "Product is saved successfully";
    }
}

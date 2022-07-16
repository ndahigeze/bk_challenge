package com.shop24.api.service;

import com.shop24.api.model.Drink;

import java.util.List;

public interface DrinkService {
    Drink findById(long id);
    List<Drink> findAll();
    void create(Drink drink);
    List<Drink> findMostConsumed(int numberToRetrieved);
}

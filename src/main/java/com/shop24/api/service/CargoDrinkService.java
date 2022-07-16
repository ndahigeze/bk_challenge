package com.shop24.api.service;

import com.shop24.api.model.CargoDrink;
import com.shop24.api.model.Client;
import com.shop24.api.model.Drink;

import java.util.List;

public interface CargoDrinkService {
    CargoDrink findById(long id);
    List<CargoDrink> findAll();
    void create(CargoDrink cargoDrink);
    List<CargoDrink> findAvailableNearlestCargoDrink(Client client);

    List<CargoDrink> findByCargoId(long id);


}

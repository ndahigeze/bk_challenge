package com.shop24.api.service;

import com.shop24.api.model.Cargo;
import com.shop24.api.model.Drink;

import java.util.List;

public interface CargoService {
    Cargo findById(long id);
    List<Cargo> findAll();
    void create(Cargo cargo);

}

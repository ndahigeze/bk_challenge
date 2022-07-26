package com.shop24.api.service;

import com.shop24.api.model.OrderDrinks;

import java.util.List;

public interface OrderDrinkService {
    OrderDrinks findById(long id);
    List<OrderDrinks> findByOrder(long id);
    List<OrderDrinks> findByClient(long id);
    void create(List<Long> cargo_drink_id,long clientId);

}

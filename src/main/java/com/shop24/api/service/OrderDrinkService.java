package com.shop24.api.service;

import com.shop24.api.model.Client;
import com.shop24.api.model.Order;
import com.shop24.api.model.OrderDrinks;

import java.util.List;

public interface OrderDrinkService {
    OrderDrinks findById(long id);
    List<OrderDrinks> findByOrder(Order order);
    List<OrderDrinks> findByClient(Client client);
    void create(OrderDrinks orderDrinks);

}

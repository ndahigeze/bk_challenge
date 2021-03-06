package com.shop24.api.service;

import com.shop24.api.model.Client;
import com.shop24.api.model.Order;

import java.util.List;

public interface OrderService {
    Order findById(long id);
    List<Order> findByClient(long client);
    List<Order>  topOrders(int counter);
    List<Order> topPaid(int counter);
    void create(Order order);
    Order changeStatus(long orderId,String status);
}

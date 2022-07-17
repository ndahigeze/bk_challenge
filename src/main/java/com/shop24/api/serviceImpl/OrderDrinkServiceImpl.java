package com.shop24.api.serviceImpl;

import com.shop24.api.dao.OrderDrinkRepository;
import com.shop24.api.model.CargoDrink;
import com.shop24.api.model.Client;
import com.shop24.api.model.Order;
import com.shop24.api.model.OrderDrinks;
import com.shop24.api.service.CargoDrinkService;
import com.shop24.api.service.ClientService;
import com.shop24.api.service.OrderDrinkService;
import com.shop24.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDrinkServiceImpl implements OrderDrinkService {
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDrinkRepository orderDrinkRepository;
    @Autowired
    private CargoDrinkService cargoDrinkService;

    @Override
    public OrderDrinks findById(long id) {
        return null;
    }

    @Override
    public List<OrderDrinks> findByOrder(long id) {
        return null;
    }

    @Override
    public List<OrderDrinks> findByClient(long id) {
        return null;
    }

    @Override
    public void create(List<Long> cargoDrinksIds, long clientId) {
      Order order=new Order();
      List<OrderDrinks> orderDrinks=new ArrayList<>();
      for(Long cdi:cargoDrinksIds){
          CargoDrink cd=cargoDrinkService.findById(cdi);
          order.setNumber_of_drinks(order.getNumber_of_drinks()+1);
          order.setTotalPrice(order.getTotalPrice()+ cd.getDrink().getPrice());
          orderDrinks.add(new OrderDrinks(order,cd));
      }
      order.setClient(clientService.findById(clientId));
      orderService.create(order);
      orderDrinkRepository.saveAll(orderDrinks);
    }
}

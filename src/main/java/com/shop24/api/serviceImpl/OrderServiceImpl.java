package com.shop24.api.serviceImpl;

import com.shop24.api.dao.OrderRepository;
import com.shop24.api.model.Client;
import com.shop24.api.model.Order;
import com.shop24.api.model.OrderStatus;
import com.shop24.api.service.OrderService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order findById(long id) {
        Optional<Order> cl=orderRepository.findById(id);
        if(cl.isPresent()){
            return cl.get();
        }else {
            throw new ObjectNotFoundException(id,"client");
        }
    }

    @Override
    public List<Order> findByClient(long clientId) {
        return orderRepository.findByClientId(clientId);
    }

    @Override
    public List<Order> topOrders(int counter) {
        return orderRepository.findAll(Pageable.ofSize(counter)).getContent();
    }

    @Override
    public List<Order> topPaid(int counter) {
        return orderRepository.findByOrderByTotalPriceDesc(Pageable.ofSize(counter));
    }

    @Override
    public void create(Order order) {
       orderRepository.save(order);
    }

    @Override
    public Order changeStatus(long orderId,String status) {
        Order order=findById(orderId);
        if(status.equalsIgnoreCase(OrderStatus.DELIVERED.toString())){
            order.setStatus(OrderStatus.DELIVERED);
        }else if(status.equalsIgnoreCase(OrderStatus.PAID.toString())){
            order.setStatus(OrderStatus.PAID);
        }else if(status.equalsIgnoreCase(OrderStatus.IN_TRANSIT.toString())){
            order.setStatus(OrderStatus.IN_TRANSIT);
        }
        create(order);
        return order;
    }
}

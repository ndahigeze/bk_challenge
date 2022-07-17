package com.shop24.api.dao;

import com.shop24.api.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByClientId(long clientId);

    List<Order> findByOrderByTotalPriceDesc(Pageable pageable);

}

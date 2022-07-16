package com.shop24.api.dao;

import com.shop24.api.model.OrderDrinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDrinkRepository extends JpaRepository<OrderDrinks,Long> {
}

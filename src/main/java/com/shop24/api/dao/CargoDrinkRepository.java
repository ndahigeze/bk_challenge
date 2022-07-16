package com.shop24.api.dao;

import com.shop24.api.model.CargoDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoDrinkRepository extends JpaRepository<CargoDrink,Long> {
    List<CargoDrink> findByCargoId(long id);
}

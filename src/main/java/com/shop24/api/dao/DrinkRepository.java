package com.shop24.api.dao;

import com.shop24.api.model.Drink;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink,Long> {
    List<Drink> findAllByOrderByConsumedTimesDesc(Pageable pageable);
}

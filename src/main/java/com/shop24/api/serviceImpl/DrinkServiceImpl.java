package com.shop24.api.serviceImpl;

import com.shop24.api.dao.DrinkRepository;
import com.shop24.api.model.Client;
import com.shop24.api.model.Drink;
import com.shop24.api.service.DrinkService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DrinkServiceImpl implements DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    @Override
    public Drink findById(long id) {
        Optional<Drink> dr=drinkRepository.findById(id);
        if(dr.isPresent()){
            return dr.get();
        }else {
            throw new ObjectNotFoundException(id,"drink");
        }
    }

    @Override
    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    @Override
    public void create(Drink drink) {
        drinkRepository.save(drink);
    }

    @Override
    public List<Drink> findMostConsumed(int numberToRetrieved) {
        return drinkRepository.findAllByOrderByConsumedTimesDesc(Pageable.ofSize(numberToRetrieved));
    }
}

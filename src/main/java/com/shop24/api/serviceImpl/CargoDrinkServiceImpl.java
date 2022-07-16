package com.shop24.api.serviceImpl;

import com.shop24.api.dao.CargoDrinkRepository;
import com.shop24.api.model.Cargo;
import com.shop24.api.model.CargoDrink;
import com.shop24.api.model.Client;
import com.shop24.api.service.CargoDrinkService;
import com.shop24.api.service.CargoService;
import com.shop24.api.util.Helpers;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CargoDrinkServiceImpl implements CargoDrinkService {
    @Autowired
    private CargoDrinkRepository cargoDrinkRepository;
    @Override
    public CargoDrink findById(long id) {
        Optional<CargoDrink> cl=cargoDrinkRepository.findById(id);
        if(cl.isPresent()){
            return cl.get();
        }else {
            throw new ObjectNotFoundException(id,"cargo drink");
        }
    }

    @Override
    public List<CargoDrink> findAll() {
        return cargoDrinkRepository.findAll();
    }

    @Override
    public void create(CargoDrink cargoDrink) {
        cargoDrinkRepository.save(cargoDrink);
    }

    @Override
    public List<CargoDrink> findAvailableNearlestCargoDrink(Client client) {
        List<CargoDrink> cargoDrinks=cargoDrinkRepository.findAll();
        List<CargoDrink> nearlest=new ArrayList<>();
        for(CargoDrink cd: cargoDrinks){
            double distance=Helpers.calculateDistance(cd.getCargo().getLongitude(),cd.getCargo().getLatitude(),client.getLongitude(),client.getLatitude());
            if(distance<=3){
                nearlest.add(cd);
            }
        }
        return nearlest;
    }

    @Override
    public List<CargoDrink> findByCargoId(long id) {
        return cargoDrinkRepository.findByCargoId(id);
    }
}

package com.shop24.api.serviceImpl;

import com.shop24.api.dao.CargoRepository;
import com.shop24.api.dao.ClientRepository;
import com.shop24.api.model.Cargo;
import com.shop24.api.model.Client;
import com.shop24.api.service.CargoService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoRepository cargoRepository;
    @Override
    public Cargo findById(long id) {
        Optional<Cargo> cl=cargoRepository.findById(id);
        if(cl.isPresent()){
            return cl.get();
        }else {
            throw new ObjectNotFoundException(id,"client");
        }

    }

    @Override
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    @Override
    public void create(Cargo cargo) {
        cargoRepository.save(cargo);
    }
}

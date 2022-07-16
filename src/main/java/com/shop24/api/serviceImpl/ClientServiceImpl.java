package com.shop24.api.serviceImpl;

import com.shop24.api.dao.ClientRepository;
import com.shop24.api.model.Client;
import com.shop24.api.service.ClientService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client findById(long id) {
        Optional<Client> cl=clientRepository.findById(id);
        if(cl.isPresent()){
            return cl.get();
        }else {
            throw new ObjectNotFoundException(id,"client");
        }

    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void create(Client client) {
     clientRepository.save(client);
    }
}

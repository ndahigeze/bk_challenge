package com.shop24.api.service;

import com.shop24.api.model.Client;

import java.util.List;

public interface ClientService {
    Client findById(long id);
    List<Client> findAll();
    void create(Client client);
}

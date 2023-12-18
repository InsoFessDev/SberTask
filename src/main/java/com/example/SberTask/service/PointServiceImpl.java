package com.example.SberTask.service;

import com.example.SberTask.model.Client;
import com.example.SberTask.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PointsServiceImpl implements PointService {
    private final ClientRepository clientRepository;

    @Autowired
    public PointsServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void addPoints(Long clientId, int amount) {
        Client client = clientRepository.findById(clientId).orElse(null);
        if (client != null) {
            client.setPoints(client.getPoints() + amount);
            clientRepository.save(client);
        }
    }

    @Override
    public void deductPoints(Long clientId, int amount) {
        Client client = clientRepository.findById(clientId).orElse(null);
        if (client != null && client.getPoints() >= amount) {
            client.setPoints(client.getPoints() - amount);
            clientRepository.save(client);
        }
    }
}
package com.example.SberTask.service;

import com.example.SberTask.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointsManagementService {
    private int limit;
    private List<Client> clients;

    public PointsManagementService() {
        this.limit = 100; // Здесь можно установить ограничение на начисляемые баллы
        this.clients = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addPoints(int clientId, int amount) {
        Client client = findClientById(clientId);
        if (client != null) {
            int currentPoints = client.getPoints();
            if (currentPoints + amount <= limit) {
                client.addPoints(amount);
            } else {
                // Обработка превышения ограничения на начисляемые баллы
                System.out.println("Вы не можете начислить " + amount + " баллов клиенту с ID " + clientId);
            }
        } else {
            // Обработка отсутствия клиента
            System.out.println("Клиент с ID " + clientId + " не найден");
        }
    }

    public void deductPoints(int clientId, int amount) {
        Client client = findClientById(clientId);
        if (client != null) {
            int currentPoints = client.getPoints();
            if (currentPoints - amount >= 0) {
                client.deductPoints(amount);
            } else {
                // Обработка отрицательного баланса баллов
                System.out.println("Недостаточно баллов для списания");
            }
        } else {
            // Обработка отсутствия клиента
            System.out.println("Клиент с ID " + clientId + " не найден");
        }
    }

    private Client findClientById(int clientId) {
        return clients.stream()
                .filter(client -> client.getId() == clientId)
                .findFirst()
                .orElse(null);
    }
}

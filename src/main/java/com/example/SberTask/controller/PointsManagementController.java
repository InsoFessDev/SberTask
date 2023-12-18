package com.example.SberTask.controller;

import com.example.SberTask.service.PointsManagementService;
import com.example.SberTask.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class PointsManagementController {
    private PointsManagementService pointsManagementService;

    @Autowired
    public PointsManagementController(PointsManagementService pointsManagementService) {
        this.pointsManagementService = pointsManagementService;
    }

    @GetMapping
    public List<Client> getClients() {
        return pointsManagementService.getClients();
    }

    @PostMapping("/{clientId}/points")
    public void addPoints(@PathVariable int clientId, @RequestParam int amount) {
        pointsManagementService.addPoints(clientId, amount);
    }

    @PutMapping("/{clientId}/points")
    public void deductPoints(@PathVariable int clientId, @RequestParam int amount) {
        pointsManagementService.deductPoints(clientId, amount);
    }
}
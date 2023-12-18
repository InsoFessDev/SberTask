package com.example.SberTask.controller;

import com.example.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointController {
    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @PostMapping("/addPoints")
    public void addPoints(@RequestBody PointRequest pointRequest) {
        pointService.addPoints(pointRequest.getClientId(), pointRequest.getAmount());
    }

    @PostMapping("/deductPoints")
    public void deductPoints(@RequestBody PointRequest pointRequest) {
        pointService.deductPoints(pointRequest.getClientId(), pointRequest.getAmount());
    }
}
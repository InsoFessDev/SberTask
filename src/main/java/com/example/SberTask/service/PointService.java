package com.example.SberTask.service;

public interface PointService {
    void addPoints(Long clientId, int amount);
    void deductPoints(Long clientId, int amount);
}

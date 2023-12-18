package com.example.SberTask.model;
public class Client {
    private int id;
    private int points;

    public Client(int id, int points) {
        this.id = id;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int amount) {
        points += amount;
    }

    public boolean deductPoints(int amount) {
        if (points >= amount) {
            points -= amount;
            return true;
        }
        return false;
    }
}
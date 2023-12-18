package com.example.SberTask.model;

public class PointRequest {
    private Long clientId;
    private int amount;

    public PointRequest() {
    }

    public PointRequest(Long clientId, int amount) {
        this.clientId = clientId;
        this.amount = amount;
    }

    public Long getClientId() {
        return clientId;
    }

    public int getAmount() {
        return amount;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

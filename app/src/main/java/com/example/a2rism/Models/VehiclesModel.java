package com.example.a2rism.Models;

public class VehiclesModel {
    private String uid;
    private String tuition;
    private String type;
    private int capacity;

    public VehiclesModel() {
    }

    public VehiclesModel(String uid, String tuition, String type, int capacity) {
        this.uid = uid;
        this.tuition = tuition;
        this.type = type;
        this.capacity = capacity;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

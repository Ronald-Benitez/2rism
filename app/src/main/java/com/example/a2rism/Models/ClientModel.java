package com.example.a2rism.Models;

import java.util.List;

public class ClientModel {
    private String uid;
    private String name;
    private String type;
    private List<TravelModel> activeTravels;
    private List<TravelModel> finishedTravels;

    public ClientModel() {
    }

    public ClientModel(String uid, String name, String type, List<TravelModel> activeTravels, List<TravelModel> finishedTravels) {
        this.uid = uid;
        this.name = name;
        this.type = type;
        this.activeTravels = activeTravels;
        this.finishedTravels = finishedTravels;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TravelModel> getActiveTravels() {
        return activeTravels;
    }

    public void setActiveTravels(List<TravelModel> activeTravels) {
        this.activeTravels = activeTravels;
    }

    public List<TravelModel> getFinishedTravels() {
        return finishedTravels;
    }

    public void setFinishedTravels(List<TravelModel> finishedTravels) {
        this.finishedTravels = finishedTravels;
    }
}

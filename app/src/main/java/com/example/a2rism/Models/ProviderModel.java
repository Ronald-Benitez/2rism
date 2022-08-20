package com.example.a2rism.Models;

import java.util.List;

public class ProviderModel {
    private String uid;
    private String type;
    private Float rating;
    private String name;
    private Boolean verified;
    private List<VehiclesModel> vehicles;
    private List<TravelModel> travels;

    public ProviderModel() {
    }

    public ProviderModel(String uid,String type, Float rating, String name, Boolean verified, List<VehiclesModel> vehicles, List<TravelModel> travels) {
        this.uid = uid;
        this.rating = rating;
        this.name = name;
        this.verified = verified;
        this.vehicles = vehicles;
        this.travels = travels;
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public List<VehiclesModel> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehiclesModel> vehicles) {
        this.vehicles = vehicles;
    }

    public List<TravelModel> getTravels() {
        return travels;
    }

    public void setTravels(List<TravelModel> travels) {
        this.travels = travels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

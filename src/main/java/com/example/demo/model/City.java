package com.example.demo.model;

public class City extends BaseCity {
    public int cityId;

    public City(int cityId, BaseCity baseCity) {
        this.cityId = cityId;
        this.name = baseCity.name;
    }
}

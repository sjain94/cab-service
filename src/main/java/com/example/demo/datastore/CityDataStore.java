package com.example.demo.datastore;

import com.example.demo.model.BaseCity;
import com.example.demo.model.City;

import java.util.List;

public interface CityDataStore {

    List<City> find();

    City getByName(String name);

    City add(BaseCity baseCity);

    City get(int cityId);
}

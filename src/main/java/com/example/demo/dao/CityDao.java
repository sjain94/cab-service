package com.example.demo.dao;

import com.example.demo.datastore.CityDataStore;
import com.example.demo.model.BaseCity;
import com.example.demo.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityDao extends IncrementalNumberGenerator implements CityDataStore {

    private static CityDao dao;
    private List<City> cities;

    @Override
    public List<City> find() {
        return cities;
    }

    @Override
    public City getByName(String name) {
        City matchingCity = null;
        for(City city: cities){
            if(city.name.equals(name)){
                matchingCity = city;
                break;
            }
        }
        return matchingCity;
    }

    @Override
    public City get(int cityId){
        City matchingCity = null;
        for(City city: cities){
            if(city.cityId == cityId){
                matchingCity = city;
                break;
            }
        }
        return matchingCity;
    }

    @Override
    public City add(BaseCity baseCity) {
        if(getByName(baseCity.name) == null){
            int nextId = getNextNumber();
            City city = new City(nextId, baseCity);
            cities.add(city);
        }
        return getByName(baseCity.name);
    }

    private CityDao() {
        this.cities = new ArrayList<>();
    }

    public static CityDao getInstance(){
        if(dao == null){
            dao = new CityDao();
        }
        return dao;
    }
}

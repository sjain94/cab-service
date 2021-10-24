package com.example.demo.blogic;

import com.example.demo.dao.CityDao;
import com.example.demo.datastore.CityDataStore;
import com.example.demo.model.BaseCity;
import com.example.demo.model.City;

import java.util.List;

public class CityManager {

    private CityDataStore cityDataStore;

    public List<City> find(){
        return cityDataStore.find();
    }

    public City add(BaseCity baseCity){
        return cityDataStore.add(baseCity);
    }

    public City get(int cityId){
        return cityDataStore.get(cityId);
    }

    public CityManager() {
        this.cityDataStore = CityDao.getInstance();
    }
}

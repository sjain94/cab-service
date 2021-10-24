package com.example.demo.blogic;

import com.example.demo.dao.CabDao;
import com.example.demo.datastore.CabDataStore;
import com.example.demo.model.BaseCab;
import com.example.demo.model.Cab;
import com.example.demo.model.CabStatus;

import java.util.List;

public class CabManager {

    private CabDataStore cabDataStore;

    public List<Cab> find(){
        return cabDataStore.find();
    }

    public Cab findMostWaitingCabInCity(int cityId){
        return cabDataStore.findMostWaitingCabInCity(cityId);
    }

    public Cab add(BaseCab baseCab){
        return cabDataStore.add(baseCab);
    }

    public void setLocation(int cabId, int cityId) throws Exception{
        cabDataStore.setLocation(cabId, cityId);
    }

    public void setStatus(int cabId, CabStatus cabStatus) throws Exception{
        cabDataStore.setStatus(cabId, cabStatus);
    }

    public void startRide(int cabId) throws Exception{
        cabDataStore.startRide(cabId);
    }

    public void endRide(int cabId) throws Exception{
        cabDataStore.endRide(cabId);
    }

    public CabManager(){
        this.cabDataStore = CabDao.getInstance();
    }
}

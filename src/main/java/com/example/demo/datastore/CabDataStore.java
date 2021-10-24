package com.example.demo.datastore;

import com.example.demo.model.*;

import java.util.List;

public interface CabDataStore {

    List<Cab> find();

    Cab findMostWaitingCabInCity(int cityId);

    Cab add(BaseCab baseCab);

    void setLocation(int cabId, int cityId) throws Exception;

    void setStatus(int cabId, CabStatus cabStatus) throws Exception;

    void startRide(int cabId) throws Exception;

    void endRide(int cabId) throws Exception;

}

package com.example.demo.model;

import java.util.Date;

public class Cab extends BaseCab {
    public int cabId;
    public CabStatus cabStatus = CabStatus.IDLE;
    public Integer currentCityId = null;
    public Date idleSince = new Date();

    public void startRide(){
        setStatus(CabStatus.ON_TRIP);
        setCurrentCity(null);
    }

    public void endRide(){
        setStatus(CabStatus.IDLE);
    }

    public void setCurrentCity(Integer cityId){
        this.currentCityId = cityId;
    }

    public void setStatus(CabStatus cabStatus){
        this.cabStatus = cabStatus;
        if(cabStatus == CabStatus.IDLE){
            idleSince = new Date();
        } else {
            idleSince = null;
        }
    }

    public Cab(int cabId, BaseCab baseCab) {
        this.cabId = cabId;
        this.licenseNumber = baseCab.licenseNumber;
        this.carType = baseCab.carType;
        this.color = baseCab.color;
        this.model = baseCab.model;
        this.cabDriver = baseCab.cabDriver;
    }
}
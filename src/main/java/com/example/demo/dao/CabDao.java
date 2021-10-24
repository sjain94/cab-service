package com.example.demo.dao;

import com.example.demo.datastore.CabDataStore;
import com.example.demo.datastore.CityDataStore;
import com.example.demo.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CabDao extends IncrementalNumberGenerator implements CabDataStore {

    private static CabDao dao;
    private List<Cab> cabs;

    @Override
    public List<Cab> find() {
        return cabs;
    }

    @Override
    public Cab findMostWaitingCabInCity(int cityId) {
        Date minWaitingSince = new Date();
        minWaitingSince.setTime(minWaitingSince.getTime() + 100000);
        Cab matchingCab = null;
        for(Cab cab: cabs){
            if(cab.currentCityId == cityId && cab.cabStatus == CabStatus.IDLE && cab.idleSince.before(minWaitingSince)){
                matchingCab = cab;
            }
        }
        return matchingCab;
    }

    @Override
    public Cab add(BaseCab baseCab) {
        if(getByLicenseNumber(baseCab.licenseNumber) == null){
            int nextId = getNextNumber();
            Cab cab = new Cab(nextId, baseCab);
            cabs.add(cab);
        }
        return getByLicenseNumber(baseCab.licenseNumber);
    }

    @Override
    public void setLocation(int cabId, int cityId) throws Exception {
        Cab cab = get(cabId);
        if(cab != null){
            cab.setCurrentCity(cityId);
        } else{
            throw new Exception("Invalid cabId");
        }
    }

    @Override
    public void setStatus(int cabId, CabStatus cabStatus) throws Exception {
        Cab cab = get(cabId);
        if(cab != null){
            cab.setStatus(cabStatus);
        } else{
            throw new Exception("Invalid cabId");
        }
    }

    @Override
    public void startRide(int cabId) throws Exception {
        Cab cab = get(cabId);
        if(cab != null){
            cab.startRide();
        } else{
            throw new Exception("Invalid cabId");
        }
    }

    @Override
    public void endRide(int cabId) throws Exception {
        Cab cab = get(cabId);
        if(cab != null){
            cab.endRide();
        } else{
            throw new Exception("Invalid cabId");
        }
    }

    private Cab get(int cabId) {
        Cab matchingCab = null;
        for(Cab cab: cabs){
            if(cab.cabId == cabId){
                matchingCab = cab;
                break;
            }
        }
        return matchingCab;
    }

    private Cab getByLicenseNumber(String licenseNumber) {
        Cab matchingCab = null;
        for(Cab cab: cabs){
            if(cab.licenseNumber.equals(licenseNumber)){
                matchingCab = cab;
                break;
            }
        }
        return matchingCab;
    }

    private CabDao() {
        this.cabs = new ArrayList<>();
    }

    public static CabDao getInstance(){
        if(dao == null){
            dao = new CabDao();
        }
        return dao;
    }
}

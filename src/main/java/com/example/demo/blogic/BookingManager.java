package com.example.demo.blogic;

import com.example.demo.dao.BookingDao;
import com.example.demo.dao.CityDao;
import com.example.demo.datastore.BookingDataStore;
import com.example.demo.datastore.CityDataStore;
import com.example.demo.model.BaseCity;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingRequest;
import com.example.demo.model.City;

import java.util.List;

public class BookingManager {

    private BookingDataStore bookingDataStore;

    public List<Booking> find(){
        return bookingDataStore.find();
    }

    public List<Booking> findByCab(int cabId){
        return bookingDataStore.findByCab(cabId);
    }

    public Booking add(BookingRequest bookingRequest){
        return bookingDataStore.add(bookingRequest);
    }

    public void complete(int bookingId){
        bookingDataStore.complete(bookingId);
    }

    public BookingManager(){
        this.bookingDataStore = BookingDao.getInstance();
    }
}

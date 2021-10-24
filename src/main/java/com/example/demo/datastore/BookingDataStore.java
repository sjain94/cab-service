package com.example.demo.datastore;

import com.example.demo.model.BaseCity;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingRequest;
import com.example.demo.model.City;

import java.awt.print.Book;
import java.util.List;

public interface BookingDataStore {

    List<Booking> find();

    List<Booking> findByCab(int cabId);

    Booking add(BookingRequest bookingRequest);

    void complete(int bookingId);
}

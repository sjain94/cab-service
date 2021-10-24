package com.example.demo.dao;

import com.example.demo.datastore.BookingDataStore;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingRequest;

import java.util.ArrayList;
import java.util.List;

public class BookingDao extends IncrementalNumberGenerator implements BookingDataStore {

    private static BookingDao dao;
    private List<Booking> bookings;

    @Override
    public List<Booking> find() {
        return bookings;
    }

    @Override
    public List<Booking> findByCab(int cabId) {
        List<Booking> cabBookings = new ArrayList<>();
        for(Booking booking: bookings){
            if(booking.getCabId() == cabId){
                cabBookings.add(booking);
            }
        }
        return cabBookings;
    }

    @Override
    public Booking add(BookingRequest bookingRequest) {
        int bookingId = getNextNumber();
        Booking booking = new Booking(bookingId, bookingRequest);
        bookings.add(booking);
        return get(bookingId);
    }

    private Booking get(int bookingId){
        Booking matchedBooking = null;
        for(Booking booking: bookings){
            if(booking.bookingId == bookingId){
                matchedBooking = booking;
                break;
            }
        }
        return matchedBooking;
    }

    @Override
    public void complete(int bookingId) {
        Booking booking = get(bookingId);
        if(booking != null){
            booking.markCompleted();
        }
    }

    private BookingDao() {
        this.bookings = new ArrayList<>();
    }

    public static BookingDao getInstance(){
        if(dao == null){
            dao = new BookingDao();
        }
        return dao;
    }
}

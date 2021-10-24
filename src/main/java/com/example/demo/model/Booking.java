package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Date;

public class Booking extends BookingRequest {
    public int bookingId;

    public Date startTime;
    public Date endTime;
    public boolean isCompleted;

    public void markCompleted(){
        this.endTime = new Date();
        this.isCompleted = true;
    }

    @JsonCreator
    public Booking(){}
    
    public Booking(int bookingId, BookingRequest request){
        this.fromCityId = request.fromCityId;
        this.toCityId = request.toCityId;
        this.cabId = request.getCabId();
        this.startTime = new Date();
        this.endTime = null;
        this.isCompleted = false;
        this.bookingId = bookingId;
    }
}

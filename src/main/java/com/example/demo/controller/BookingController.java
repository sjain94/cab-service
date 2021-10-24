package com.example.demo.controller;


import com.example.demo.blogic.BookingManager;
import com.example.demo.blogic.CabManager;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingRequest;
import com.example.demo.model.Cab;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private CabManager cabManager;
    private BookingManager bookingManager;

    @PostMapping("")
    public Booking bookACab(@RequestBody BookingRequest bookingRequest) throws Exception{
        Cab cab = cabManager.findMostWaitingCabInCity(bookingRequest.fromCityId);
        if(cab != null){
            bookingRequest.setCabId(cab.cabId);
            return bookingManager.add(bookingRequest);
        } else {
            throw new Exception("No cabs found for service");
        }
    }

    @GetMapping("")
    public List<Booking> getCabBookingHistory(@RequestParam(value = "cabId", required = false) Integer cabId){
        if(cabId == null){
            return bookingManager.find();
        } else {
            return bookingManager.findByCab(cabId);
        }
    }

    @PostMapping("/{bookingId}/complete")
    public void complete(@PathVariable int bookingId){
        bookingManager.complete(bookingId);
    }

    public BookingController() {
        this.cabManager = new CabManager();
        this.bookingManager = new BookingManager();
    }
}

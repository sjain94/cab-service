package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class BookingRequest {
    public int fromCityId;
    public int toCityId;
    public Integer cabId;

    public Integer getCabId() {
        return cabId;
    }

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }

    @JsonCreator
    public BookingRequest(){}
}

package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CabUpdate {
    public int cabId;
    public Integer cityId = null;
    public CabStatus cabStatus = null;

    @JsonCreator
    public CabUpdate(){}
}

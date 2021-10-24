package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class BaseCab {
    public String licenseNumber;
    public CarType carType;
    public String color;
    public String model;
    public CabDriver cabDriver;

    @JsonCreator
    public BaseCab(){}
}
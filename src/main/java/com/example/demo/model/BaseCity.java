package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseCity {
    public String name;

    @JsonCreator
    public BaseCity(){}
}

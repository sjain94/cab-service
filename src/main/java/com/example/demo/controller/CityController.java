package com.example.demo.controller;


import com.example.demo.blogic.CityManager;
import com.example.demo.model.BaseCity;
import com.example.demo.model.City;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cities")
public class CityController {

    private CityManager cityManager;

    @GetMapping("")
    public List<City> find() {
        return cityManager.find();
    }

    @PostMapping("")
    public City add(@RequestBody BaseCity baseCity){
        return cityManager.add(baseCity);
    }

    public CityController() {
        this.cityManager = new CityManager();
    }
}

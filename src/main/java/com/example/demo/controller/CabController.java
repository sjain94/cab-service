package com.example.demo.controller;


import com.example.demo.blogic.CabManager;
import com.example.demo.blogic.CityManager;
import com.example.demo.model.BaseCab;
import com.example.demo.model.Cab;
import com.example.demo.model.CabUpdate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabs")
public class CabController {

    private CabManager cabManager;
    private CityManager cityManager;

    @GetMapping("")
    public List<Cab> find(){
        return cabManager.find();
    }

    @PostMapping("")
    public Cab add(@RequestBody BaseCab baseCab){
        return cabManager.add(baseCab);
    }

    @PutMapping("")
    public void updateCab(@RequestBody CabUpdate cabUpdate) throws Exception{
        if(cabUpdate.cabStatus != null){
            cabManager.setStatus(cabUpdate.cabId, cabUpdate.cabStatus);
        }
        if(cabUpdate.cityId != null && cityManager.get(cabUpdate.cityId) != null){
            cabManager.setLocation(cabUpdate.cabId, cabUpdate.cityId);
        }
    }

    public CabController(){
        this.cabManager = new CabManager();
        this.cityManager = new CityManager();
    }
}

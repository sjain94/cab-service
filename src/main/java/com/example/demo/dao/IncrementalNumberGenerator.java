package com.example.demo.dao;

class IncrementalNumberGenerator {

    private int lastGeneratedId = 0;

    protected int getNextNumber(){
        return ++lastGeneratedId;
    }
}

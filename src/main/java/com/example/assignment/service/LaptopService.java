package com.example.assignment.service;

import com.example.assignment.Laptop;
import com.example.assignment.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;

    //create new laptop
    public void addLaptop(Laptop laptop){
        laptopRepository.save(laptop);
    }

    //get laptop
    public Laptop getLaptop(int id){
        return laptopRepository.findById(id).get();
    }
}

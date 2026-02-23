package com.gabriel.service;

import com.gabriel.model.Laptop;
import com.gabriel.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop lap) {
        repo.save(lap);
    }

    public boolean isGoofProg(Laptop lap) {
        return true;
    }

}

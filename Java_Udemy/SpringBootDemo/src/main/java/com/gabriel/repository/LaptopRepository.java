package com.gabriel.repository;

import com.gabriel.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void save(Laptop laptop) {
        System.out.println("Saved in Database...");
    }
}

package com.didorenko.labs.util;

import com.didorenko.labs.lab2.Lab2;
import com.didorenko.labs.lab3.Lab3;
import com.didorenko.labs.lab3.Motorcycle;
import com.didorenko.labs.lab3.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by g.didorenko on 26.03.2018.
 */

@Component
public class Initializer {

    @Value("${laboratory.work}")
    private String laboratoryWorkName;

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    private List<com.didorenko.labs.lab1.Motorcycle> firstMotorcycles;
    private Lab2 lab2 = new Lab2();
    private Lab3 lab3;

    @PostConstruct
    public void init() {
        switch (laboratoryWorkName) {
            case "lab1": {
                final List<Motorcycle> allMotorcycles = motorcycleRepository.findAll();
                List<com.didorenko.labs.lab1.Motorcycle> motorcycles = allMotorcycles.stream()
                        .map(motorcycle -> new com.didorenko.labs.lab1.Motorcycle(motorcycle.getWeight(), motorcycle.getPrice(), motorcycle.getCapacity(), motorcycle.getProducer()))
                        .collect(Collectors.toList());

                motorcycles.get(0).addAll(motorcycles.subList(1, motorcycles.size()));
                break;
            }
            case "lab2": {
                final List<Motorcycle> allMotorcycles = motorcycleRepository.findAll();
                lab2.addAll(allMotorcycles.stream()
                        .map(motorcycle -> new com.didorenko.labs.lab2.Motorcycle(motorcycle.getWeight(), motorcycle.getPrice(), motorcycle.getCapacity(), motorcycle.getProducer()))
                        .collect(Collectors.toList()));
                break;
            }
            case "lab3": {
                break;
            }
            default:
                throw new IllegalArgumentException("Pass 'laboratory.work' program argument with valid value (lab1/lab2/lab3)");
        }
    }

    public Lab2 getLab2() {
        return lab2;
    }

}

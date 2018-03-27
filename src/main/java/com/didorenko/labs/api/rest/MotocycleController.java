package com.didorenko.labs.api.rest;

import com.didorenko.labs.GenericLaboratoryWork;
import com.didorenko.labs.lab2.Lab2;
import com.didorenko.labs.lab2.Motorcycle;
import com.didorenko.labs.lab3.Lab3;
import com.didorenko.labs.util.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by g.didorenko on 23.03.2018.
 */

@RestController
public class MotocycleController {

    @Autowired
    private Initializer initializer;

    private GenericLaboratoryWork lab;

    @PostConstruct
    public void load() throws IOException {
        lab = initializer.getLab();
    }

    @GetMapping(path = "element")
    public Object getCurrentElement() {
        return lab.getCurrentElement();
    }

    @GetMapping(path = "capacity/next")
    public Object nextCapacity() {
        return lab.nextCapacity();
    }

    @GetMapping(path = "capacity/previous")
    public Object previousCapacity() {
        return lab.previousCapacity();
    }

    @GetMapping(path = "capacity/first")
    public Object firstCapacity() {
        return lab.getFirstCapacity();
    }

    @GetMapping(path = "capacity/last")
    public Object lastCapacity() {
        return lab.getLastCapacity();
    }


    @GetMapping(path = "weight/next")
    public Object nextWeight() {
        return lab.nextWeight();
    }

    @GetMapping(path = "weight/previous")
    public Object previousWeight() {
        return lab.previousWeight();
    }

    @GetMapping(path = "weight/first")
    public Object firstWeight() {
        return lab.getFirstWeight();
    }

    @GetMapping(path = "weight/last")
    public Object lastWeight() {
        return lab.getLastWeight();
    }


    @GetMapping(path = "price/next")
    public Object nextPrice() {
        return lab.nextPrice();
    }

    @GetMapping(path = "price/previous")
    public Object previousPrice() {
        return lab.previousPrice();
    }

    @GetMapping(path = "price/first")
    public Object firstPrice() {
        return lab.getFirstPrice();
    }

    @GetMapping(path = "price/last")
    public Object lastPrice() {
        return lab.getLastPrice();
    }


    @GetMapping(path = "producer/next")
    public Object nextProducer() {
        return lab.nextProducer();
    }

    @GetMapping(path = "producer/previous")
    public Object previousProducer() {
        return lab.previousProducer();
    }

    @GetMapping(path = "producer/first")
    public Object firstProducer() {
        return lab.getFirstProducer();
    }

    @GetMapping(path = "producer/last")
    public Object lastProducer() {
        return lab.getLastProducer();
    }


    @PostMapping(path = "add")
    public void add(@RequestBody Motorcycle element) {
        if (lab instanceof com.didorenko.labs.lab1.Motorcycle)
            ((com.didorenko.labs.lab1.Motorcycle)lab)
                    .add(new com.didorenko.labs.lab1.Motorcycle(element.getWeight(), element.getPrice(), element.getCapacity(), element.getProducer()));

        if (lab instanceof Lab2)
            ((Lab2) lab).add(element);

        if (lab instanceof Lab3)
            ((Lab3) lab).add(new com.didorenko.labs.lab3.Motorcycle(element.getWeight(), element.getPrice(), element.getCapacity(), element.getProducer()));
    }

    @PostMapping(path = "remove/{id}")
    public void remove(@PathVariable int id) {
        lab.remove(id);
    }

    @GetMapping(path = "search")
    public Object search(@RequestParam(required = false) Integer capacity,
                         @RequestParam(required = false) Integer price,
                         @RequestParam(required = false, name = "weight") Integer weight,
                         @RequestParam(required = false) String producer) {
        if (!Objects.isNull(capacity))
            return lab.searchCapacity(capacity);

        if (!Objects.isNull(price))
            return lab.searchPrice(price);

        if (!Objects.isNull(weight))
            return lab.searchWeight(weight);

        if (!Objects.isNull(producer))
            return lab.searchProducer(producer);

        return null;
    }
}

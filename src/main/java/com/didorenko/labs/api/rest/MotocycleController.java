package com.didorenko.labs.api.rest;

import com.didorenko.labs.lab2.Lab2;
import com.didorenko.labs.lab2.Motorcycle;
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

    private Lab2 lab2;

    @PostConstruct
    public void load() throws IOException {
        lab2 = initializer.getLab2();
    }



    @PostMapping(path = "add")
    public void add(@RequestBody Motorcycle element) {
        lab2.add(element);
    }

    @PostMapping(path = "remove/{id}")
    public void remove(@PathVariable int id) {
        lab2.remove(id);
    }

    @GetMapping(path = "search")
    public Motorcycle search(@RequestParam(required = false) Integer capacity,
                             @RequestParam(required = false) Integer price,
                             @RequestParam(required = false) Integer weight,
                             @RequestParam(required = false) String producer) {
        if (!Objects.isNull(capacity))
            return lab2.searchCapacity(capacity);

        if (!Objects.isNull(price))
            return lab2.searchPrice(price);

        if (!Objects.isNull(weight))
            return lab2.searchWeight(weight);

        if (!Objects.isNull(producer))
            return lab2.searchProducer(producer);

        return null;
    }
}

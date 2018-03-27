package com.didorenko.labs.lab2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by g.didorenko on 23.03.2018.
 */

public class Motorcycle {

    private static int instanceCounter;

    private int id;
    private int weight;
    private int price;
    private int capacity;
    private String producer;

    @JsonCreator
    public Motorcycle(@JsonProperty("weight") int weight, @JsonProperty("price") int price,
                      @JsonProperty("capacity") int capacity, @JsonProperty("producer") String producer) {
        id = ++instanceCounter;
        this.weight = weight;
        this.price = price;
        this.capacity = capacity;
        this.producer = producer;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getProducer() {
        return producer;
    }

    public int getId() {
        return id;
    }
}

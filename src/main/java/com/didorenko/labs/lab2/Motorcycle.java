package com.didorenko.labs.lab2;

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

    public Motorcycle(int weight, int price, int capacity, String producer) {
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

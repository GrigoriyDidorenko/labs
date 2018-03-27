package com.didorenko.labs.lab3;

import javax.persistence.*;

/**
 * Created by g.didorenko on 23.03.2018.
 */

@Entity
@Table(name = "motorcycles")
public class Motorcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "weight")
    private int weight;

    @Column(name = "price")
    private int price;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "producer")
    private String producer;

    @Column(name = "previous_capacity")
    private Integer previousCapacity;

    @Column(name = "next_capacity")
    private Integer nextCapacity;

    @Column(name = "previous_price")
    private Integer previousPrice;

    @Column(name = "next_price")
    private Integer nextPrice;

    @Column(name = "previous_weight")
    private Integer previousWeight;

    @Column(name = "next_weight")
    private Integer nextWeight;

    @Column(name = "previous_producer")
    private Integer previousProducer;

    @Column(name = "next_producer")
    private Integer nextProducer;

    public Motorcycle() {
    }

    public Motorcycle(int weight, int price, int capacity, String producer) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getPreviousCapacity() {
        return previousCapacity;
    }

    public void setPreviousCapacity(Integer previousCapacity) {
        this.previousCapacity = previousCapacity;
    }

    public Integer getNextCapacity() {
        return nextCapacity;
    }

    public void setNextCapacity(Integer nextCapacity) {
        this.nextCapacity = nextCapacity;
    }

    public Integer getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(Integer previousPrice) {
        this.previousPrice = previousPrice;
    }

    public Integer getNextPrice() {
        return nextPrice;
    }

    public void setNextPrice(Integer nextPrice) {
        this.nextPrice = nextPrice;
    }

    public Integer getPreviousWeight() {
        return previousWeight;
    }

    public void setPreviousWeight(Integer previousWeight) {
        this.previousWeight = previousWeight;
    }

    public Integer getNextWeight() {
        return nextWeight;
    }

    public void setNextWeight(Integer nextWeight) {
        this.nextWeight = nextWeight;
    }

    public Integer getPreviousProducer() {
        return previousProducer;
    }

    public void setPreviousProducer(Integer previousProducer) {
        this.previousProducer = previousProducer;
    }

    public Integer getNextProducer() {
        return nextProducer;
    }

    public void setNextProducer(Integer nextProducer) {
        this.nextProducer = nextProducer;
    }
}

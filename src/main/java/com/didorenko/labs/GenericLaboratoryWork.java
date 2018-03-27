package com.didorenko.labs;

import com.didorenko.labs.lab3.Motorcycle;

/**
 * Created by g.didorenko on 26.03.2018.
 */
interface GenericLaboratoryWork {

    Motorcycle getCurrentElement();

    void add(Motorcycle motorcycle);

    void remove(int id);

    Motorcycle getLastCapacity();

    Motorcycle getFirstCapacity();

    Motorcycle nextCapacity();

    Motorcycle previousCapacity();

    Motorcycle getLastWeight();

    Motorcycle getFirstWeight();

    Motorcycle nextWeight();

    Motorcycle previousWeight();


    Motorcycle getLastPrice();

    Motorcycle getFirstPrice();

    Motorcycle nextPrice();

    Motorcycle previousPrice();


    Motorcycle getLastProducer();

    Motorcycle getFirstProducer();

    Motorcycle nextProducer();

    Motorcycle previousProducer();

    Motorcycle searchCapacity(int capacity);

    Motorcycle searchWeight(int weight);

    Motorcycle searchPrice(int price);

    Motorcycle searchProducer(String producer);
}

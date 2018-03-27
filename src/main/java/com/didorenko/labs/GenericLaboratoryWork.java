package com.didorenko.labs;

import com.didorenko.labs.lab3.Motorcycle;

/**
 * Created by g.didorenko on 26.03.2018.
 */
public interface GenericLaboratoryWork<T> {

    T getCurrentElement();

    void add(T motorcycle);

    void remove(int id);

    T getLastCapacity();

    T getFirstCapacity();

    T nextCapacity();

    T previousCapacity();

    T getLastWeight();

    T getFirstWeight();

    T nextWeight();

    T previousWeight();


    T getLastPrice();

    T getFirstPrice();

    T nextPrice();

    T previousPrice();


    T getLastProducer();

    T getFirstProducer();

    T nextProducer();

    T previousProducer();

    T searchCapacity(int capacity);

    T searchWeight(int weight);

    T searchPrice(int price);

    T searchProducer(String producer);
}

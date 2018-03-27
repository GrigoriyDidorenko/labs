package com.didorenko.labs.lab3;

import com.didorenko.labs.GenericLaboratoryWork;
import com.didorenko.labs.lab3.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by g.didorenko on 26.03.2018.
 */

@Component
public class Lab3 implements GenericLaboratoryWork<Motorcycle> {

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    private int currentElementIndex = 1;

    public Motorcycle getCurrentElement() {
        return motorcycleRepository.findOne(currentElementIndex);
    }

    public void add(Motorcycle motorcycle) {
        final Motorcycle savedMotorcycle = motorcycleRepository.save(motorcycle);

        Optional<Motorcycle> elementToInsertAfter = Optional.ofNullable(motorcycleRepository.findCapacityInsertionPosition(savedMotorcycle.getCapacity()));

        if (!elementToInsertAfter.isPresent()) {
            addLastCapacity(savedMotorcycle);
            return;
        }

        if (isFirst(elementToInsertAfter.get())) {
            addFirst(elementToInsertAfter.get(), savedMotorcycle);
            return;
        }

        commonAdd(elementToInsertAfter.get(), savedMotorcycle);
    }

    public void remove(int id) {
        final Motorcycle motorcycle = motorcycleRepository.findOne(id);

        Optional.ofNullable(motorcycle.getNextCapacity())
                .ifPresent(nextCapacity -> {
                    final Motorcycle nextCapacityElement = motorcycleRepository.findOne(nextCapacity);
                    nextCapacityElement.setPreviousCapacity(motorcycle.getPreviousCapacity());
                    motorcycleRepository.save(nextCapacityElement);
                });

        Optional.ofNullable(motorcycle.getPreviousCapacity())
                .ifPresent(nextCapacity -> {
                    final Motorcycle previousCapacityElement = motorcycleRepository.findOne(nextCapacity);
                    previousCapacityElement.setNextCapacity(motorcycle.getNextCapacity());
                    motorcycleRepository.save(previousCapacityElement);
                });

        motorcycleRepository.delete(id);
    }

    private void commonAdd(Motorcycle elementToInsertAfter, Motorcycle motorcycle) {
        motorcycle.setNextCapacity(elementToInsertAfter.getNextCapacity());
        Motorcycle elementToInsertBefore = motorcycleRepository.findOne(elementToInsertAfter.getNextCapacity());

        motorcycle.setPreviousCapacity(elementToInsertBefore.getPreviousCapacity());
        int insertedMotorcycleId = motorcycleRepository.save(motorcycle).getId();

        elementToInsertAfter.setNextCapacity(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertAfter);

        elementToInsertBefore.setPreviousCapacity(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertBefore);
    }

    private void addFirst(Motorcycle elementToInsertAfter, Motorcycle motorcycle) {
        motorcycle.setNextCapacity(elementToInsertAfter.getId());
        int insertedMotorcycleId = motorcycleRepository.save(motorcycle).getId();

        elementToInsertAfter.setPreviousCapacity(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertAfter);
    }

    private boolean isFirst(Motorcycle motorcycle) {
        return !Optional.ofNullable(motorcycle.getPreviousCapacity()).isPresent();
    }

    private void addLastCapacity(Motorcycle motorcycle) {
        Motorcycle lastCapacityElement = motorcycleRepository.findLastCapacity();

        motorcycle.setPreviousCapacity(lastCapacityElement.getId());
        final int savedId = motorcycleRepository.save(motorcycle).getId();

        lastCapacityElement.setNextCapacity(savedId);
        motorcycleRepository.save(lastCapacityElement);
    }

    public Motorcycle getLastCapacity() {
        final Motorcycle lastCapacityMotorcycle = motorcycleRepository.findLastCapacity();
        currentElementIndex = lastCapacityMotorcycle.getId();
        return lastCapacityMotorcycle;
    }

    public Motorcycle getFirstCapacity() {
        final Motorcycle firstCapacityMotorcycle = motorcycleRepository.findFirstCapacity();
        currentElementIndex = firstCapacityMotorcycle.getId();
        return firstCapacityMotorcycle;
    }

    public Motorcycle nextCapacity() {
        currentElementIndex = motorcycleRepository.findOne(currentElementIndex)
                .getNextCapacity();

        return motorcycleRepository.findOne(currentElementIndex);
    }

    public Motorcycle previousCapacity() {
        currentElementIndex = motorcycleRepository.findOne(currentElementIndex)
                .getPreviousCapacity();

        return motorcycleRepository.findOne(currentElementIndex);
    }

    public Motorcycle getLastWeight() {
        final Motorcycle lastWeightMotorcycle = motorcycleRepository.findLastWeight();
        currentElementIndex = lastWeightMotorcycle.getId();
        return lastWeightMotorcycle;
    }

    public Motorcycle getFirstWeight() {
        final Motorcycle firstWeightMotorcycle = motorcycleRepository.findFirstWeight();
        currentElementIndex = firstWeightMotorcycle.getId();
        return firstWeightMotorcycle;
    }

    public Motorcycle nextWeight() {
        currentElementIndex = motorcycleRepository.findOne(currentElementIndex)
                .getNextWeight();

        return motorcycleRepository.findOne(currentElementIndex);
    }

    public Motorcycle previousWeight() {
        currentElementIndex = motorcycleRepository.findOne(currentElementIndex)
                .getPreviousWeight();

        return motorcycleRepository.findOne(currentElementIndex);
    }


    public Motorcycle getLastPrice() {
        final Motorcycle lastPriceMotorcycle = motorcycleRepository.findLastPrice();
        currentElementIndex = lastPriceMotorcycle.getId();
        return lastPriceMotorcycle;
    }

    public Motorcycle getFirstPrice() {
        final Motorcycle firstPriceMotorcycle = motorcycleRepository.findFirstPrice();
        currentElementIndex = firstPriceMotorcycle.getId();
        return firstPriceMotorcycle;
    }

    public Motorcycle nextPrice() {
        currentElementIndex = motorcycleRepository.findOne(currentElementIndex)
                .getNextPrice();

        return motorcycleRepository.findOne(currentElementIndex);
    }

    public Motorcycle previousPrice() {
        currentElementIndex = motorcycleRepository.findOne(currentElementIndex)
                .getPreviousPrice();

        return motorcycleRepository.findOne(currentElementIndex);
    }


    public Motorcycle getLastProducer() {
        final Motorcycle lastProducerMotorcycle = motorcycleRepository.findLastProducer();
        currentElementIndex = lastProducerMotorcycle.getId();
        return lastProducerMotorcycle;
    }

    public Motorcycle getFirstProducer() {
        final Motorcycle firstProducerMotorcycle = motorcycleRepository.findFirstProducer();
        currentElementIndex = firstProducerMotorcycle.getId();
        return firstProducerMotorcycle;
    }

    public Motorcycle nextProducer() {
        currentElementIndex = motorcycleRepository.findOne(currentElementIndex)
                .getNextProducer();

        return motorcycleRepository.findOne(currentElementIndex);
    }

    public Motorcycle previousProducer() {
        currentElementIndex = motorcycleRepository.findOne(currentElementIndex)
                .getPreviousProducer();

        return motorcycleRepository.findOne(currentElementIndex);
    }

    public Motorcycle searchCapacity(int capacity) {
        return motorcycleRepository.findByCapacity(capacity);
    }

    public Motorcycle searchWeight(int weight) {
        return motorcycleRepository.findByWeight(weight);
    }

    public Motorcycle searchPrice(int price) {
        return motorcycleRepository.findByPrice(price);
    }

    public Motorcycle searchProducer(String producer) {
        return motorcycleRepository.findByProducer(producer);
    }


}

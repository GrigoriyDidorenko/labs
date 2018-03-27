package com.didorenko.labs.lab3;

import com.didorenko.labs.GenericLaboratoryWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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

    @Transactional
    public void add(Motorcycle motorcycle) {
        final Motorcycle savedMotorcycle = motorcycleRepository.save(motorcycle);

        Optional<Motorcycle> elementToInsertAfter = Optional.ofNullable(motorcycleRepository.findCapacityInsertionPosition(savedMotorcycle.getId(), savedMotorcycle.getCapacity()));

        if (!elementToInsertAfter.isPresent()) {
            addLastCapacity(savedMotorcycle);
            return;
        } else if (isFirstCapacity(elementToInsertAfter.get())) {
            addFirstCapacity(elementToInsertAfter.get(), savedMotorcycle);
        } else {

            commonAddCapacity(elementToInsertAfter.get(), savedMotorcycle);
        }


        Optional<Motorcycle> elementToInsertAfterWeight = Optional.ofNullable(motorcycleRepository.findWeightInsertionPosition(savedMotorcycle.getId(), savedMotorcycle.getWeight()));

        if (!elementToInsertAfterWeight.isPresent()) {
            addLastWeight(savedMotorcycle);
        } else if (isFirstWeight(elementToInsertAfterWeight.get())) {
            addFirstWeight(elementToInsertAfterWeight.get(), savedMotorcycle);
        } else commonAddWeight(elementToInsertAfterWeight.get(), savedMotorcycle);


        Optional<Motorcycle> elementToInsertAfterPrice = Optional.ofNullable(motorcycleRepository.findPriceInsertionPosition(savedMotorcycle.getId(), savedMotorcycle.getPrice()));

        if (!elementToInsertAfterPrice.isPresent()) {
            addLastPrice(savedMotorcycle);
        } else if (isFirstPrice(elementToInsertAfterPrice.get())) {
            addFirstPrice(elementToInsertAfterPrice.get(), savedMotorcycle);
        } else commonAddPrice(elementToInsertAfterPrice.get(), savedMotorcycle);


        Optional<Motorcycle> elementToInsertAfterProducer = Optional.ofNullable(motorcycleRepository.findProducerInsertionPosition(savedMotorcycle.getId(), savedMotorcycle.getProducer()));

        if (!elementToInsertAfterProducer.isPresent()) {
            addLastProducer(savedMotorcycle);
        } else if (isFirstProducer(elementToInsertAfterProducer.get())) {
            addFirstProducer(elementToInsertAfterProducer.get(), savedMotorcycle);
        } else commonAddProducer(elementToInsertAfterProducer.get(), savedMotorcycle);
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

    private void commonAddCapacity(Motorcycle elementToInsertAfter, Motorcycle motorcycle) {
        motorcycle.setNextCapacity(elementToInsertAfter.getNextCapacity());
        Motorcycle elementToInsertBefore = motorcycleRepository.findOne(elementToInsertAfter.getNextCapacity());

        motorcycle.setPreviousCapacity(elementToInsertBefore.getPreviousCapacity());
        int insertedMotorcycleId = motorcycleRepository.save(motorcycle).getId();

        elementToInsertAfter.setNextCapacity(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertAfter);

        elementToInsertBefore.setPreviousCapacity(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertBefore);
    }

    private void addFirstCapacity(Motorcycle elementToInsertAfter, Motorcycle motorcycle) {
        motorcycle.setNextCapacity(elementToInsertAfter.getId());
        int insertedMotorcycleId = motorcycleRepository.save(motorcycle).getId();

        elementToInsertAfter.setPreviousCapacity(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertAfter);
    }

    private boolean isFirstCapacity(Motorcycle motorcycle) {
        return !Optional.ofNullable(motorcycle.getPreviousCapacity()).isPresent();
    }

    private void addLastCapacity(Motorcycle motorcycle) {
        Motorcycle lastCapacityElement = motorcycleRepository.findLastCapacity();

        motorcycle.setPreviousCapacity(lastCapacityElement.getId());
        final int savedId = motorcycleRepository.save(motorcycle).getId();

        lastCapacityElement.setNextCapacity(savedId);
        motorcycleRepository.save(lastCapacityElement);
    }


    private void commonAddWeight(Motorcycle elementToInsertAfter, Motorcycle motorcycle) {
        motorcycle.setNextWeight(elementToInsertAfter.getNextWeight());
        Motorcycle elementToInsertBefore = motorcycleRepository.findOne(elementToInsertAfter.getNextWeight());

        motorcycle.setPreviousWeight(elementToInsertBefore.getPreviousWeight());
        int insertedMotorcycleId = motorcycleRepository.save(motorcycle).getId();

        elementToInsertAfter.setNextWeight(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertAfter);

        elementToInsertBefore.setPreviousWeight(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertBefore);
    }

    private void addFirstWeight(Motorcycle elementToInsertAfter, Motorcycle motorcycle) {
        motorcycle.setNextWeight(elementToInsertAfter.getId());
        int insertedMotorcycleId = motorcycleRepository.save(motorcycle).getId();

        elementToInsertAfter.setPreviousWeight(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertAfter);
    }

    private boolean isFirstWeight(Motorcycle motorcycle) {
        return !Optional.ofNullable(motorcycle.getPreviousWeight()).isPresent();
    }

    private void addLastWeight(Motorcycle motorcycle) {
        Motorcycle lastWeightElement = motorcycleRepository.findLastWeight();

        motorcycle.setPreviousWeight(lastWeightElement.getId());
        final int savedId = motorcycleRepository.save(motorcycle).getId();

        lastWeightElement.setNextWeight(savedId);
        motorcycleRepository.save(lastWeightElement);
    }


    private void commonAddPrice(Motorcycle elementToInsertAfter, Motorcycle motorcycle) {
        motorcycle.setNextPrice(elementToInsertAfter.getNextPrice());
        Motorcycle elementToInsertBefore = motorcycleRepository.findOne(elementToInsertAfter.getNextPrice());

        motorcycle.setPreviousPrice(elementToInsertBefore.getPreviousPrice());
        int insertedMotorcycleId = motorcycleRepository.save(motorcycle).getId();

        elementToInsertAfter.setNextPrice(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertAfter);

        elementToInsertBefore.setPreviousPrice(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertBefore);
    }

    private void addFirstPrice(Motorcycle elementToInsertAfter, Motorcycle motorcycle) {
        motorcycle.setNextPrice(elementToInsertAfter.getId());
        int insertedMotorcycleId = motorcycleRepository.save(motorcycle).getId();

        elementToInsertAfter.setPreviousPrice(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertAfter);
    }

    private boolean isFirstPrice(Motorcycle motorcycle) {
        return !Optional.ofNullable(motorcycle.getPreviousPrice()).isPresent();
    }

    private void addLastPrice(Motorcycle motorcycle) {
        Motorcycle lastPriceElement = motorcycleRepository.findLastPrice();

        motorcycle.setPreviousPrice(lastPriceElement.getId());
        final int savedId = motorcycleRepository.save(motorcycle).getId();

        lastPriceElement.setNextPrice(savedId);
        motorcycleRepository.save(lastPriceElement);
    }


    private void commonAddProducer(Motorcycle elementToInsertAfter, Motorcycle motorcycle) {
        motorcycle.setNextProducer(elementToInsertAfter.getNextProducer());
        Motorcycle elementToInsertBefore = motorcycleRepository.findOne(elementToInsertAfter.getNextProducer());

        motorcycle.setPreviousProducer(elementToInsertBefore.getPreviousProducer());
        int insertedMotorcycleId = motorcycleRepository.save(motorcycle).getId();

        elementToInsertAfter.setNextProducer(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertAfter);

        elementToInsertBefore.setPreviousProducer(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertBefore);
    }

    private void addFirstProducer(Motorcycle elementToInsertAfter, Motorcycle motorcycle) {
        motorcycle.setNextProducer(elementToInsertAfter.getId());
        int insertedMotorcycleId = motorcycleRepository.save(motorcycle).getId();

        elementToInsertAfter.setPreviousProducer(insertedMotorcycleId);
        motorcycleRepository.save(elementToInsertAfter);
    }

    private boolean isFirstProducer(Motorcycle motorcycle) {
        return !Optional.ofNullable(motorcycle.getPreviousProducer()).isPresent();
    }

    private void addLastProducer(Motorcycle motorcycle) {
        Motorcycle lastProducerElement = motorcycleRepository.findLastProducer();

        motorcycle.setPreviousProducer(lastProducerElement.getId());
        final int savedId = motorcycleRepository.save(motorcycle).getId();

        lastProducerElement.setNextProducer(savedId);
        motorcycleRepository.save(lastProducerElement);
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

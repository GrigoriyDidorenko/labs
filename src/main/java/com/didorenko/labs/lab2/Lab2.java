package com.didorenko.labs.lab2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by g.didorenko on 23.03.2018.
 */
public class Lab2 {

    private List<Motorcycle> motorcycles = new ArrayList<>();

    private LinkedList<Integer> capacityIndexArray = new LinkedList<>();
    private LinkedList<Integer> weightIndexArray = new LinkedList<>();
    private LinkedList<Integer> priceIndexArray = new LinkedList<>();
    private LinkedList<Integer> producerIndexArray = new LinkedList<>();

    private int currentElementIndex = 0;

    public void addAll(Collection<Motorcycle> motorcycles) {
        motorcycles.forEach(this::add);
    }

    public void add(Motorcycle e) {
        motorcycles.add(e);

        boolean isInsertedCapacity = false;
        for (int i = 0; i < capacityIndexArray.size(); i++) {
            final Motorcycle motorcycle = motorcycles.get(capacityIndexArray.get(i));
            final int capacityCompare = Integer.compare(motorcycle.getCapacity(), e.getCapacity());
            if (capacityCompare > 0) {
                capacityIndexArray.add(i > 0 ? i - 1 : 0, motorcycles.size() - 1);
                isInsertedCapacity = true;
                break;
            }
        }

        if (!isInsertedCapacity)
            capacityIndexArray.add(motorcycles.size() - 1);


        boolean isInsertedPrice = false;
        for (int i = 0; i < priceIndexArray.size(); i++) {
            final Motorcycle motorcycle = motorcycles.get(priceIndexArray.get(i));
            final int priceCompare = Integer.compare(motorcycle.getPrice(), e.getPrice());
            if (priceCompare > 0) {
                priceIndexArray.add(i > 0 ? i - 1 : 0, motorcycles.size() - 1);
                isInsertedPrice = true;
                break;
            }
        }

        if (!isInsertedPrice)
            priceIndexArray.add(motorcycles.size() - 1);


        boolean isInsertedWeight = false;
        for (int i = 0; i < weightIndexArray.size(); i++) {
            final Motorcycle motorcycle = motorcycles.get(weightIndexArray.get(i));
            final int weightCompare = Integer.compare(motorcycle.getWeight(), e.getWeight());
            if (weightCompare > 0) {
                weightIndexArray.add(i > 0 ? i - 1 : 0, motorcycles.size() - 1);
                isInsertedWeight = true;
                break;
            }
        }

        if (!isInsertedWeight)
            weightIndexArray.add(motorcycles.size() - 1);

        boolean isInsertedProducer = false;
        for (int i = 0; i < producerIndexArray.size(); i++) {
            final Motorcycle motorcycle = motorcycles.get(producerIndexArray.get(i));
            final int producerCompare = motorcycle.getProducer().compareTo(e.getProducer());
            if (producerCompare > 0) {
                producerIndexArray.add(i > 0 ? i - 1 : 0, motorcycles.size() - 1);
                isInsertedProducer = true;
                break;
            }
        }

        if (!isInsertedProducer)
            producerIndexArray.add(motorcycles.size() - 1);
    }

    public Motorcycle nextCapacity() {
        for (int i = 0; i < capacityIndexArray.size(); i++) {
            if (capacityIndexArray.get(i) == currentElementIndex && i < capacityIndexArray.size() - 1) {
                currentElementIndex = capacityIndexArray.get(i + 1);
                return motorcycles.get(currentElementIndex);
            }
        }

        return null;
    }

    public Motorcycle nextWeight() {
        for (int i = 0; i < weightIndexArray.size(); i++) {
            if (weightIndexArray.get(i) == currentElementIndex && i < weightIndexArray.size() - 1) {
                currentElementIndex = weightIndexArray.get(i + 1);
                return motorcycles.get(currentElementIndex);
            }
        }

        return null;
    }

    public Motorcycle nextPrice() {
        for (int i = 0; i < priceIndexArray.size(); i++) {
            if (priceIndexArray.get(i) == currentElementIndex && i < priceIndexArray.size() - 1) {
                currentElementIndex = priceIndexArray.get(i + 1);
                return motorcycles.get(currentElementIndex);
            }
        }

        return null;
    }

    public Motorcycle nextProducer() {
        for (int i = 0; i < producerIndexArray.size(); i++) {
            if (producerIndexArray.get(i) == currentElementIndex && i < producerIndexArray.size() - 1) {
                currentElementIndex = producerIndexArray.get(i + 1);
                return motorcycles.get(currentElementIndex);
            }
        }

        return null;
    }


    public Motorcycle previousCapacity() {
        for (int i = 0; i < capacityIndexArray.size(); i++) {
            if (capacityIndexArray.get(i) == currentElementIndex && i > 0) {
                currentElementIndex = capacityIndexArray.get(i - 1);
                return motorcycles.get(currentElementIndex);
            }
        }

        return null;
    }

    public Motorcycle previousWeight() {
        for (int i = 0; i < weightIndexArray.size(); i++) {
            if (weightIndexArray.get(i) == currentElementIndex && i > 0) {
                currentElementIndex = weightIndexArray.get(i - 1);
                return motorcycles.get(currentElementIndex);
            }
        }

        return null;
    }

    public Motorcycle previousPrice() {
        for (int i = 0; i < priceIndexArray.size(); i++) {
            if (priceIndexArray.get(i) == currentElementIndex && i > 0) {
                currentElementIndex = priceIndexArray.get(i - 1);
                return motorcycles.get(currentElementIndex);
            }
        }

        return null;
    }

    public Motorcycle previousProducer() {
        for (int i = 0; i < producerIndexArray.size(); i++) {
            if (producerIndexArray.get(i) == currentElementIndex && i > 0) {
                currentElementIndex = producerIndexArray.get(i - 1);
                return motorcycles.get(currentElementIndex);
            }
        }

        return null;
    }

    public Motorcycle getFirstCapacity() {
        if (capacityIndexArray.isEmpty())
            return null;

        currentElementIndex = capacityIndexArray.getFirst();
        return motorcycles.get(currentElementIndex);
    }

    public Motorcycle getFirstWeight() {
        if (weightIndexArray.isEmpty())
            return null;

        currentElementIndex = weightIndexArray.getFirst();
        return motorcycles.get(currentElementIndex);
    }

    public Motorcycle getFirstPrice() {
        if (producerIndexArray.isEmpty())
            return null;

        currentElementIndex = producerIndexArray.getFirst();
        return motorcycles.get(currentElementIndex);
    }

    public Motorcycle getFirstProducer() {
        if (producerIndexArray.isEmpty())
            return null;

        currentElementIndex = producerIndexArray.getFirst();
        return motorcycles.get(currentElementIndex);
    }


    public Motorcycle getLastCapacity() {
        if (capacityIndexArray.isEmpty())
            return null;

        currentElementIndex = capacityIndexArray.getLast();
        return motorcycles.get(currentElementIndex);
    }

    public Motorcycle getLastWeight() {
        if (weightIndexArray.isEmpty())
            return null;

        currentElementIndex = weightIndexArray.getLast();
        return motorcycles.get(currentElementIndex);
    }

    public Motorcycle getLastPrice() {
        if (priceIndexArray.isEmpty())
            return null;

        currentElementIndex = priceIndexArray.getLast();
        return motorcycles.get(currentElementIndex);
    }

    public Motorcycle getLastProducer() {
        if (producerIndexArray.isEmpty())
            return null;

        currentElementIndex = producerIndexArray.getLast();
        return motorcycles.get(currentElementIndex);
    }

    public void remove(int id) {
        for (int i = 0; i < motorcycles.size(); i++) {
            if (motorcycles.get(i).getId() == id) {
                motorcycles.remove(i);

                for (int j = 0; j < capacityIndexArray.size(); j++) {
                    if (capacityIndexArray.get(j) == i)
                        capacityIndexArray.remove(j);
                }

                for (int j = 0; j < weightIndexArray.size(); j++) {
                    if (weightIndexArray.get(j) == i)
                        weightIndexArray.remove(j);
                }

                for (int j = 0; j < producerIndexArray.size(); j++) {
                    if (producerIndexArray.get(j) == i)
                        producerIndexArray.remove(j);
                }

                for (int j = 0; j < priceIndexArray.size(); j++) {
                    if (priceIndexArray.get(j) == i)
                        priceIndexArray.remove(j);
                }

                break;
            }
        }
    }

    public Motorcycle getCurrentElement() {
        return motorcycles.get(currentElementIndex);
    }

    public Motorcycle searchCapacity(int searchCapacity) {
        if (capacityIndexArray.isEmpty())
            return null;

        int low = 0;
        int high = capacityIndexArray.size() - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (searchCapacity > motorcycles.get(capacityIndexArray.get(middle)).getCapacity()) {
                low = middle + 1;
            } else if (searchCapacity < motorcycles.get(capacityIndexArray.get(middle)).getCapacity()) {
                high = middle - 1;
            } else {
                return motorcycles.get(capacityIndexArray.get(middle));
            }
        }

        return null;
    }

    public Motorcycle searchWeight(int searchWeight) {
        if (weightIndexArray.isEmpty())
            return null;

        int low = 0;
        int high = weightIndexArray.size() - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (searchWeight > motorcycles.get(weightIndexArray.get(middle)).getWeight()) {
                low = middle + 1;
            } else if (searchWeight < motorcycles.get(weightIndexArray.get(middle)).getWeight()) {
                high = middle - 1;
            } else {
                return motorcycles.get(weightIndexArray.get(middle));
            }
        }

        return null;
    }

    public Motorcycle searchPrice(int searchPrice) {
        if (priceIndexArray.isEmpty())
            return null;

        int low = 0;
        int high = priceIndexArray.size() - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (searchPrice > motorcycles.get(priceIndexArray.get(middle)).getPrice()) {
                low = middle + 1;
            } else if (searchPrice < motorcycles.get(priceIndexArray.get(middle)).getPrice()) {
                high = middle - 1;
            } else {
                return motorcycles.get(priceIndexArray.get(middle));
            }
        }

        return null;
    }

    public Motorcycle searchProducer(String searchProducer) {
        if (producerIndexArray.isEmpty())
            return null;

        int low = 0;
        int high = producerIndexArray.size() - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (searchProducer.compareTo(motorcycles.get(producerIndexArray.get(middle)).getProducer()) > 0) {
                low = middle + 1;
            } else if (searchProducer.compareTo(motorcycles.get(producerIndexArray.get(middle)).getProducer()) < 0) {
                high = middle - 1;
            } else {
                return motorcycles.get(producerIndexArray.get(middle));
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Motorcycle root = new Motorcycle(1, 1, 1, "");
        Motorcycle first = new Motorcycle(1, 1, -3, "");
        Motorcycle second = new Motorcycle(1, 1, 4, "");
        Motorcycle third = new Motorcycle(1, 1, -15, "");
        Motorcycle fourth = new Motorcycle(1, 1, 26, "");

        final Lab2 lab2 = new Lab2();

        lab2.add(root);
        lab2.add(first);
        lab2.add(second);
        lab2.add(third);
        lab2.add(fourth);

        System.out.println(lab2.capacityIndexArray);

    }
}

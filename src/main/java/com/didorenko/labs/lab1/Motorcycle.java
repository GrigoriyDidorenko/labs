package com.didorenko.labs.lab1;

import com.didorenko.labs.GenericLaboratoryWork;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by g.didorenko on 22.03.2018.
 */
public class Motorcycle implements GenericLaboratoryWork<Motorcycle> {

    private static Motorcycle first;
    private static int instanceCounter;

    private int id;
    private int weight;
    private int price;
    private int capacity;
    private String producer;

    private static Motorcycle currentElement;

    private Motorcycle nextWeight;
    private Motorcycle previousWeight;
    private Motorcycle nextPrice;
    private Motorcycle previousPrice;
    private Motorcycle nextCapacity;
    private Motorcycle previousCapacity;
    private Motorcycle nextProducer;
    private Motorcycle previousProducer;

    public Motorcycle(int weight, int price, int capacity, String producer) {
        id = ++instanceCounter;
        this.weight = weight;
        this.price = price;
        this.capacity = capacity;
        this.producer = producer;
    }

    public void addAll(Collection<Motorcycle> motorcycles) {
        motorcycles.forEach(this::add);
    }


    @Override
    public Motorcycle getCurrentElement() {
        return currentElement;
    }

    public void add(Motorcycle e) {
        if (Objects.isNull(first))
            currentElement = first = e;
        else {


            final int capacityCompare = Integer.compare(first.capacity, e.capacity);
            Motorcycle currentElement = first;
            if (capacityCompare > 0) {
                while (true) {
                    if (Objects.isNull(currentElement.previousCapacity)) {
                        currentElement.previousCapacity = e;
                        e.nextCapacity = currentElement;
                        break;
                    }

                    if ((Integer.compare(currentElement.capacity, e.capacity) <= 0)) {
                        currentElement.nextCapacity.previousCapacity = e;
                        e.nextCapacity = currentElement.nextCapacity;
                        e.previousCapacity = currentElement;
                        currentElement.nextCapacity = e;
                        break;
                    }

                    currentElement = currentElement.previousCapacity;
                }
            } else {
                while (true) {
                    if (Objects.isNull(currentElement.nextCapacity)) {
                        currentElement.nextCapacity = e;
                        e.previousCapacity = currentElement;
                        break;
                    }

                    if ((Integer.compare(currentElement.capacity, e.capacity) > 0)) {
                        currentElement.previousCapacity.nextCapacity = e;
                        e.nextCapacity = currentElement;
                        e.previousCapacity = currentElement.previousCapacity;
                        currentElement.previousCapacity = e;
                        break;
                    }

                    currentElement = currentElement.nextCapacity;
                }
            }


            final int weightCompare = Integer.compare(first.weight, e.weight);
            if (weightCompare > 0) {
                while (true) {
                    if (Objects.isNull(currentElement.previousWeight)) {
                        currentElement.previousWeight = e;
                        e.nextWeight = currentElement;
                        break;
                    }

                    if ((Integer.compare(currentElement.weight, e.weight) <= 0)) {
                        currentElement.nextWeight.previousWeight = e;
                        e.nextWeight = currentElement.nextWeight;
                        e.previousWeight = currentElement;
                        currentElement.nextWeight = e;
                        break;
                    }

                    currentElement = currentElement.previousWeight;
                }
            } else {
                while (true) {
                    if (Objects.isNull(currentElement.nextWeight)) {
                        currentElement.nextWeight = e;
                        e.previousWeight = currentElement;
                        break;
                    }

                    if ((Integer.compare(currentElement.weight, e.weight) > 0)) {
                        currentElement.previousWeight.nextWeight = e;
                        e.nextWeight = currentElement;
                        e.previousWeight = currentElement.previousWeight;
                        currentElement.previousWeight = e;
                        break;
                    }

                    currentElement = currentElement.nextWeight;
                }
            }


            final int priceCompare = Integer.compare(first.price, e.price);
            if (priceCompare > 0) {
                while (true) {
                    if (Objects.isNull(currentElement.previousPrice)) {
                        currentElement.previousPrice = e;
                        e.nextPrice = currentElement;
                        break;
                    }

                    if ((Integer.compare(currentElement.price, e.price) <= 0)) {
                        currentElement.nextPrice.previousPrice = e;
                        e.nextPrice = currentElement.nextPrice;
                        e.previousPrice = currentElement;
                        currentElement.nextPrice = e;
                        break;
                    }

                    currentElement = currentElement.previousPrice;
                }
            } else {
                while (true) {
                    if (Objects.isNull(currentElement.nextPrice)) {
                        currentElement.nextPrice = e;
                        e.previousPrice = currentElement;
                        break;
                    }

                    if ((Integer.compare(currentElement.price, e.price) > 0)) {
                        currentElement.previousPrice.nextPrice = e;
                        e.nextPrice = currentElement;
                        e.previousPrice = currentElement.previousPrice;
                        currentElement.previousPrice = e;
                        break;
                    }

                    currentElement = currentElement.nextPrice;
                }
            }


            final int producerCompare = first.producer.compareTo(e.producer);
            if (producerCompare > 0) {
                while (true) {
                    if (Objects.isNull(currentElement.previousProducer)) {
                        currentElement.previousProducer = e;
                        e.nextProducer = currentElement;
                        break;
                    }

                    if (currentElement.producer.compareTo(e.producer) <= 0) {
                        currentElement.nextProducer.previousProducer = e;
                        e.nextProducer = currentElement.nextProducer;
                        e.previousProducer = currentElement;
                        currentElement.nextProducer = e;
                        break;
                    }

                    currentElement = currentElement.previousProducer;
                }
            } else {
                while (true) {
                    if (Objects.isNull(currentElement.nextProducer)) {
                        currentElement.nextProducer = e;
                        e.previousProducer = currentElement;
                        break;
                    }

                    if (currentElement.producer.compareTo(e.producer) > 0) {
                        currentElement.previousProducer.nextProducer = e;
                        e.nextProducer = currentElement;
                        e.previousProducer = currentElement.previousProducer;
                        currentElement.previousProducer = e;
                        break;
                    }

                    currentElement = currentElement.nextProducer;
                }
            }
        }
    }

    public Motorcycle nextCapacity() {
        if (Objects.isNull(currentElement.nextCapacity))
            return null;

        currentElement = currentElement.nextCapacity;
        return currentElement;
    }

    public Motorcycle previousCapacity() {
        if (Objects.isNull(currentElement.previousCapacity))
            return null;

        currentElement = currentElement.previousCapacity;
        return currentElement;
    }

    public Motorcycle getFirstCapacity() {
        while (true) {
            final Motorcycle previousCapacity = previousCapacity();
            if (previousCapacity == null)
                break;

            currentElement = currentElement.previousCapacity;
        }

        return currentElement;
    }

    public Motorcycle getLastCapacity() {
        while (true) {
            final Motorcycle nextCapacity = nextCapacity();
            if (nextCapacity == null)
                break;

            currentElement = currentElement.nextCapacity;
        }

        return currentElement;
    }

    public Motorcycle nextWeight() {
        if (Objects.isNull(currentElement.nextWeight))
            return null;

        currentElement = currentElement.nextWeight;
        return currentElement;
    }

    public Motorcycle previousWeight() {
        if (Objects.isNull(currentElement.previousWeight))
            return null;

        currentElement = currentElement.previousWeight;
        return currentElement;
    }

    public Motorcycle getFirstWeight() {
        while (true) {
            final Motorcycle previousCapacity = previousWeight();
            if (previousCapacity == null)
                break;

            currentElement = currentElement.previousWeight;
        }

        return currentElement;
    }

    public Motorcycle getLastWeight() {
        while (true) {
            final Motorcycle nextCapacity = nextWeight();
            if (nextCapacity == null)
                break;

            currentElement = currentElement.nextWeight;
        }

        return currentElement;
    }

    public Motorcycle nextPrice() {
        if (Objects.isNull(currentElement.nextPrice))
            return null;

        currentElement = currentElement.nextPrice;
        return currentElement;
    }

    public Motorcycle previousPrice() {
        if (Objects.isNull(currentElement.previousPrice))
            return null;

        currentElement = currentElement.previousPrice;
        return currentElement;
    }

    public Motorcycle getFirstPrice() {
        while (true) {
            final Motorcycle previousPrice = previousPrice();
            if (previousPrice == null)
                break;

            currentElement = currentElement.previousPrice;
        }

        return currentElement;
    }

    public Motorcycle getLastPrice() {
        while (true) {
            final Motorcycle nextPrice = nextPrice();
            if (nextPrice == null)
                break;

            currentElement = currentElement.nextPrice;
        }

        return currentElement;
    }

    public Motorcycle nextProducer() {
        if (Objects.isNull(currentElement.nextProducer))
            return null;

        currentElement = currentElement.nextProducer;
        return currentElement;
    }

    public Motorcycle previousProducer() {
        if (Objects.isNull(currentElement.previousProducer))
            return null;

        currentElement = currentElement.previousProducer;
        return currentElement;
    }

    public Motorcycle getFirstProducer() {
        while (true) {
            final Motorcycle previousProducer = previousProducer();
            if (previousProducer == null)
                break;

            currentElement = currentElement.previousProducer;
        }

        return currentElement;
    }

    public Motorcycle getLastProducer() {
        while (true) {
            final Motorcycle nextProducer = nextProducer();
            if (nextProducer == null)
                break;

            currentElement = currentElement.nextProducer;
        }

        return currentElement;
    }

    public Motorcycle searchCapacity(int capacity) {
        Motorcycle currentElement = first;
        final int compare = Integer.compare(currentElement.capacity, capacity);

        if (compare > 0) {
            while (true) {
                if (Integer.compare(currentElement.capacity, capacity) == 0)
                    return currentElement;

                if (Objects.isNull(currentElement.previousCapacity))
                    return null;

                currentElement = currentElement.previousCapacity;
            }
        } else {
            while (true) {
                if (Integer.compare(currentElement.capacity, capacity) == 0)
                    return currentElement;

                if (Objects.isNull(currentElement.nextCapacity))
                    return null;

                currentElement = currentElement.nextCapacity;
            }
        }
    }

    public Motorcycle searchWeight(int weight) {
        Motorcycle currentElement = first;
        final int compare = Integer.compare(currentElement.weight, weight);

        if (compare > 0) {
            while (true) {
                if (Integer.compare(currentElement.weight, weight) == 0)
                    return currentElement;

                if (Objects.isNull(currentElement.previousWeight))
                    return null;

                currentElement = currentElement.previousWeight;
            }
        } else {
            while (true) {
                if (Integer.compare(currentElement.weight, weight) == 0)
                    return currentElement;

                if (Objects.isNull(currentElement.nextWeight))
                    return null;

                currentElement = currentElement.nextWeight;
            }
        }
    }

    public Motorcycle searchPrice(int price) {
        Motorcycle currentElement = first;
        final int compare = Integer.compare(currentElement.price, price);

        if (compare > 0) {
            while (true) {
                if (Integer.compare(currentElement.price, price) == 0)
                    return currentElement;

                if (Objects.isNull(currentElement.previousPrice))
                    return null;

                currentElement = currentElement.previousPrice;
            }
        } else {
            while (true) {
                if (Integer.compare(currentElement.price, price) == 0)
                    return currentElement;

                if (Objects.isNull(currentElement.nextPrice))
                    return null;

                currentElement = currentElement.nextPrice;
            }
        }
    }

    public Motorcycle searchProducer(String producer) {
        Motorcycle currentElement = first;
        final int compare = currentElement.producer.compareTo(producer);

        if (compare > 0) {
            while (true) {
                if (currentElement.producer.compareTo(producer) == 0)
                    return currentElement;

                if (Objects.isNull(currentElement.previousProducer))
                    return null;

                currentElement = currentElement.previousProducer;
            }
        } else {
            while (true) {
                if (currentElement.producer.compareTo(producer) == 0)
                    return currentElement;

                if (Objects.isNull(currentElement.nextProducer))
                    return null;

                currentElement = currentElement.nextProducer;
            }
        }
    }

    public void remove(int id) {
        Motorcycle currentPointer = currentElement;

        getFirstCapacity();
        while (true) {
            if (currentElement.id == id) {
                if (!Objects.isNull(currentElement.nextCapacity))
                    currentElement.nextCapacity.previousCapacity = currentElement.previousCapacity;

                if (!Objects.isNull(currentElement.previousCapacity))
                    currentElement.previousCapacity.nextCapacity = currentElement.nextCapacity;

                currentElement = null;
                break;
            }

            if (currentElement.nextCapacity() == null)
                break;

        }

        currentElement = currentPointer;
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

    public Motorcycle getNextWeight() {
        return nextWeight;
    }

    public Motorcycle getPreviousWeight() {
        return previousWeight;
    }

    public Motorcycle getNextPrice() {
        return nextPrice;
    }

    public Motorcycle getPreviousPrice() {
        return previousPrice;
    }

    public Motorcycle getNextCapacity() {
        return nextCapacity;
    }

    public Motorcycle getPreviousCapacity() {
        return previousCapacity;
    }

    public Motorcycle getNextProducer() {
        return nextProducer;
    }

    public Motorcycle getPreviousProducer() {
        return previousProducer;
    }

//    public static void main(String[] args) {
//        Motorcycle root = new Motorcycle(1, 1, 1, "");
//        Motorcycle first = new Motorcycle(1, 1, -3, "");
//        Motorcycle second = new Motorcycle(1, 1, 4, "");
//        Motorcycle third = new Motorcycle(1, 1, -15, "");
//        Motorcycle fourth = new Motorcycle(1, 1, 26, "");
//
//        root.add(root);
//        root.add(first);
//        root.add(second);
//        root.add(third);
//        root.add(fourth);
//
//        root.remove(5);
//
//        System.out.println();
//
//    }
//
//    @Override
//    public String toString() {
//        return "Motorcycle{" +
//                "weight=" + weight +
//                ", price=" + price +
//                ", capacity=" + capacity +
//                ", producer='" + producer + '\'' +
//                '}';
//    }
}

package com.didorenko.labs.lab3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by g.didorenko on 26.03.2018.
 */
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Integer> {

    @Query(value = "select * from motorcycles m where m.previous_capacity is null limit 1", nativeQuery = true)
    Motorcycle findFirstCapacity();

    @Query(value = "select * from motorcycles m where m.next_capacity is null limit 1", nativeQuery = true)
    Motorcycle findLastCapacity();

    @Query(value = "select * from motorcycles m where m.previous_weight is null limit 1", nativeQuery = true)
    Motorcycle findFirstWeight();

    @Query(value = "select * from motorcycles m where m.next_weight is null limit 1", nativeQuery = true)
    Motorcycle findLastWeight();

    @Query(value = "select * from motorcycles m where m.previous_price is null limit 1", nativeQuery = true)
    Motorcycle findFirstPrice();

    @Query(value = "select * from motorcycles m where m.next_price is null limit 1", nativeQuery = true)
    Motorcycle findLastPrice();

    @Query(value = "select * from motorcycles m where m.previous_producer is null limit 1", nativeQuery = true)
    Motorcycle findFirstProducer();

    @Query(value = "select * from motorcycles m where m.next_producer is null limit 1", nativeQuery = true)
    Motorcycle findLastProducer();




    Motorcycle findByCapacity(int capacity);

    @Query(value = "select * from motorcycles m " +
            "where m.capacity >= ?2 and m.id <> ?1 " +
            "ORDER BY m.capacity " +
            "LIMIT 1", nativeQuery = true)
    Motorcycle findCapacityInsertionPosition(int id, int capacity);


    @Query(value = "select * from motorcycles m " +
            "where m.weight >= ?2 and m.id <> ?1 " +
            "ORDER BY m.capacity " +
            "LIMIT 1", nativeQuery = true)
    Motorcycle findWeightInsertionPosition(int id, int weight);


    @Query(value = "select * from motorcycles m " +
            "where m.price >= ?2 and m.id <> ?1 " +
            "ORDER BY m.capacity " +
            "LIMIT 1", nativeQuery = true)
    Motorcycle findPriceInsertionPosition(int id, int price);


    @Query(value = "select * from motorcycles m " +
            "where m.producer >= ?2 and m.id <> ?1 " +
            "ORDER BY m.capacity " +
            "LIMIT 1", nativeQuery = true)
    Motorcycle findProducerInsertionPosition(int id, String producer);

    Motorcycle findByProducer(String producer);

    Motorcycle findByWeight(int weight);

    Motorcycle findByPrice(int weight);
}

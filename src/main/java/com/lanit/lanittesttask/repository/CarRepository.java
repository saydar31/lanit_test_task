package com.lanit.lanittesttask.repository;

import com.lanit.lanittesttask.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "select count(distinct split_part(c.model, '-', 1)) " +
            "from car c", nativeQuery = true)
    long countAllByVendor();

    @Query("select distinct c.model from Car c")
    Set<String> getModels();

}
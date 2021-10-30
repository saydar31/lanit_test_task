package com.lanit.lanittesttask.repository;

import com.lanit.lanittesttask.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p join fetch p.cars where p.id = :id")
    Optional<Person> findByIdFetchCars(Long id);
}
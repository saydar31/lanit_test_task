package com.lanit.lanittesttask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Table(name = "person")
@Entity
@Getter
@Setter
public class Person {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

    public Long getAge() {
        return ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }
}
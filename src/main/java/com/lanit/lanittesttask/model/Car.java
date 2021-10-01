package com.lanit.lanittesttask.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "car")
@Entity
@Getter
@Setter
public class Car {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "horsepower", nullable = false)
    private Integer horsepower;

    @ManyToOne
    private Person owner;

}
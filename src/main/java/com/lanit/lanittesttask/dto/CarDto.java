package com.lanit.lanittesttask.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private Long id;
    private String model;
    private Integer horsepower;
    private Long ownerId;
}

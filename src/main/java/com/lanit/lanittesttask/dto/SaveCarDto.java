package com.lanit.lanittesttask.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class SaveCarDto {

    @NotNull
    private Long id;

    @NotNull
    @Pattern(regexp = "^\\w+-\\w+$")
    private String model;

    @Min(1)
    @NotNull
    private Integer horsepower;

    @NotNull
    private Long ownerId;
}

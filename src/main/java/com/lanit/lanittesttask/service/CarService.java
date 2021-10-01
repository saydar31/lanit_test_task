package com.lanit.lanittesttask.service;

import com.lanit.lanittesttask.dto.SaveCarDto;

public interface CarService {
    void save(SaveCarDto saveCarDto);

    long getCarCount();

    long getUniqueVendorCount();

    void clear();
}

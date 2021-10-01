package com.lanit.lanittesttask.service;

import com.lanit.lanittesttask.dto.PersonWithCarsDto;
import com.lanit.lanittesttask.dto.SavePersonDto;
import com.lanit.lanittesttask.model.Person;

public interface PersonService {
    void save(SavePersonDto savePersonDto);

    Person getPerson(Long id);

    PersonWithCarsDto getPersonWithCars(Long id);

    long getPersonCount();

    void clear();
}

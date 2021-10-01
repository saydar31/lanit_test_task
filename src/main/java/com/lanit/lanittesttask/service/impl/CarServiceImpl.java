package com.lanit.lanittesttask.service.impl;

import com.lanit.lanittesttask.dto.SaveCarDto;
import com.lanit.lanittesttask.exception.ValidationException;
import com.lanit.lanittesttask.model.Car;
import com.lanit.lanittesttask.model.Person;
import com.lanit.lanittesttask.repository.CarRepository;
import com.lanit.lanittesttask.repository.PersonRepository;
import com.lanit.lanittesttask.service.CarService;
import com.lanit.lanittesttask.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PersonService personService;
    private final ModelMapper modelMapper;

    private static final int ABLE_TO_DRIVE_AGE = 18;

    @Override
    public void save(SaveCarDto saveCarDto) {
        var owner = personService.getPerson(saveCarDto.getOwnerId());
        if (owner.getAge() < ABLE_TO_DRIVE_AGE || carRepository.existsById(saveCarDto.getId())) {
            throw new ValidationException();
        }
        Car car = modelMapper.map(saveCarDto, Car.class);
        carRepository.save(car);
    }

    @Override
    public long getCarCount() {
        return carRepository.count();
    }

    @Override
    public long getUniqueVendorCount() {
        return carRepository.countAllByVendor();
    }

    @Override
    public void clear() {
        carRepository.deleteAll();
    }
}

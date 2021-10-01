package com.lanit.lanittesttask.service.impl;

import com.lanit.lanittesttask.dto.Statistics;
import com.lanit.lanittesttask.service.CarService;
import com.lanit.lanittesttask.service.PersonService;
import com.lanit.lanittesttask.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {
    private final PersonService personService;
    private final CarService carService;

    @Override
    public Statistics getStatistics() {
        var statistics = new Statistics();
        statistics.setPersonCount(personService.getPersonCount());
        statistics.setCarCount(carService.getCarCount());
        statistics.setUniqueVendorCount(carService.getUniqueVendorCount());
        return statistics;
    }
}

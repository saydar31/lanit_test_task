package com.lanit.lanittesttask.service.impl;

import com.lanit.lanittesttask.service.CarService;
import com.lanit.lanittesttask.service.ClearService;
import com.lanit.lanittesttask.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClearServiceImpl implements ClearService {

    private final PersonService personService;

    private final CarService carService;

    @Override
    public void clear() {
        carService.clear();
        personService.clear();
    }
}

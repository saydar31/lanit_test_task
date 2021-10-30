package com.lanit.lanittesttask.controller;

import com.lanit.lanittesttask.dto.SaveCarDto;
import com.lanit.lanittesttask.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
@Slf4j
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<Void> saveCar(@RequestBody @Valid SaveCarDto saveCarDto){
        log.info("{} is valid", saveCarDto);
        carService.save(saveCarDto);
        return ResponseEntity.ok().build();
    }
}

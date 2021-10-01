package com.lanit.lanittesttask.controller;

import com.lanit.lanittesttask.dto.PersonWithCarsDto;
import com.lanit.lanittesttask.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personwithcars")
@RequiredArgsConstructor
public class PersonWithCarController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<PersonWithCarsDto> getPersonWithCar(@RequestParam("personid") Long id) {
        return ResponseEntity.ok(personService.getPersonWithCars(id));
    }
}

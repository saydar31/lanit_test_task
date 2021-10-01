package com.lanit.lanittesttask.controller;

import com.lanit.lanittesttask.dto.SavePersonDto;
import com.lanit.lanittesttask.service.PersonService;
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
@RequestMapping("/person")
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    private final PersonService personService;

    @PostConstruct
    public void init(){
        log.info("PersonController is ready");
    }

    @PostMapping
    public ResponseEntity<Void> addPerson(@RequestBody @Valid SavePersonDto savePersonDto) {
        log.info("{} is valid", savePersonDto);
        personService.save(savePersonDto);
        return ResponseEntity.ok().build();
    }
}

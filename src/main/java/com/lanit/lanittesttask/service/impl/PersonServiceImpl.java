package com.lanit.lanittesttask.service.impl;

import com.lanit.lanittesttask.dto.PersonWithCarsDto;
import com.lanit.lanittesttask.dto.SavePersonDto;
import com.lanit.lanittesttask.exception.NotFoundException;
import com.lanit.lanittesttask.exception.ValidationException;
import com.lanit.lanittesttask.model.Person;
import com.lanit.lanittesttask.repository.PersonRepository;
import com.lanit.lanittesttask.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(SavePersonDto savePersonDto) {
        if (personRepository.existsById(savePersonDto.getId())
                || savePersonDto.getBirthdate().isAfter(LocalDate.now())) {
            throw new ValidationException();
        }
        Person person = modelMapper.map(savePersonDto, Person.class);
        personRepository.save(person);
    }

    @Override
    public Person getPerson(Long id) {
        return personRepository.findById(id)
                .orElseThrow(ValidationException::new);
    }

    @Override
    public PersonWithCarsDto getPersonWithCars(Long id) {
        Person person = personRepository.findByIdFetchCars(id).orElseThrow(NotFoundException::new);
        return modelMapper.map(person, PersonWithCarsDto.class);
    }

    @Override
    public long getPersonCount() {
        return personRepository.count();
    }

    @Override
    public void clear() {
        personRepository.deleteAll();
    }
}

package com.acme.api.controller;

import com.acme.api.service.DogService;
import com.acme.datasource.model.Dog;
import com.acme.datasource.model.Gender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DogControllerTest {

    public DogController dogController = new DogController(new DogService());

    @Test
    public void readAllTest()
    {
        ResponseEntity<List<Dog>> responseEntity = dogController.readAll(null);
        assertEquals(5, Objects.requireNonNull(responseEntity.getBody()).size());
    }

    @Test
    public void readByIdTest()
    {
        ResponseEntity<Dog> responseEntity = dogController.readById("111");
        assertEquals("Balto", Objects.requireNonNull(responseEntity.getBody()).getName());
    }

    @Test
    public void createTest()
    {
        Dog dog = new Dog();
        dog.setId("111");
        dog.setName("Jimmy");
        SimpleDateFormat date = new SimpleDateFormat();
        dog.setBirthDate(LocalDate.of(2020, 12, 12));
        dog.setSpecies("Siberian Husky");
        dog.setGender(Gender.M);
        ResponseEntity<Dog> responseEntity = dogController.create(dog);
        assertEquals("Jimmy", Objects.requireNonNull(responseEntity.getBody()).getName());
    }

    @Test
    public void updateTest()
    {
        Dog dog = new Dog();
        dog.setId("111");
        dog.setName("Jimmy");
        dog.setBirthDate(LocalDate.of(2020, 12, 12));
        dog.setSpecies("Saint Bernard");
        dog.setGender(Gender.M);
        ResponseEntity<Dog> responseEntity = dogController.update("111", dog);
        assertEquals("Saint Bernard", Objects.requireNonNull(responseEntity.getBody()).getSpecies());
    }

    @Test
    public void deleteTest()
    {
        ResponseEntity<Void> responseEntity = dogController.delete("111");
        assertEquals("200", Objects.requireNonNull(responseEntity.getStatusCode()).toString());
    }
}

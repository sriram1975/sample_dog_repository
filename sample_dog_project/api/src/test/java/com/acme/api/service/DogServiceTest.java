package com.acme.api.service;

import com.acme.datasource.model.Dog;
import com.acme.datasource.model.Gender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class DogServiceTest {

	DogService dogService = new DogService();

    @Test
    public void readAllTest()
    {
        List<Dog> dogList = dogService.readAll(null);
        assertEquals(5, dogList.size());
    }

    @Test
    public void readByIdTest()
    {
        Optional<Dog> dog = dogService.readById("111");
        assertEquals("Balto", dog.orElseThrow().getName());
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
        assertTrue(dogService.create(dog));
    }

    @Test
    void updateTest()
    {
        Dog dog = new Dog();
        dog.setId("111");
        dog.setName("Jimmy");
        dog.setBirthDate(LocalDate.of(2020, 12, 12));
        dog.setSpecies("Saint Bernard");
        dog.setGender(Gender.M);
        assertTrue(dogService.update("111", dog));
    }

    @Test
    void deleteTest() {
        assertTrue(dogService.delete("111"));
    }
}

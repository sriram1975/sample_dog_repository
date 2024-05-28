package com.acme.datasource.impl;

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
class DogServiceImplTest {

	private DogDatasourceImpl dogDatasourceImpl;

	@Test
	void initTest() {
		dogDatasourceImpl.init();
		List<Dog> dogList = dogDatasourceImpl.readAll();
		assertEquals(5, dogList.size());
	}

	@Test
	void createTest() {
		Dog dog = new Dog();
		dog.setId("111");
		dog.setName("Jimmy");
		SimpleDateFormat date = new SimpleDateFormat();
		dog.setBirthDate(LocalDate.of(2020, 12, 12));
		dog.setSpecies("Siberian Husky");
		dog.setGender(Gender.M);
		assertTrue(dogDatasourceImpl.create(dog));
	}

	@Test
	void updateTest() {
		Dog dog = new Dog();
		dog.setId("111");
		dog.setName("Jimmy");
		dog.setBirthDate(LocalDate.of(2020, 12, 12));
		dog.setSpecies("Saint Bernard");
		dog.setGender(Gender.M);
		assertTrue(dogDatasourceImpl.update(dog));
	}

	@Test
	void readByIdTest() {
		Optional<Dog> optionalDog = dogDatasourceImpl.readById("111");
		Dog dog = optionalDog.orElseThrow();
		assertEquals("111", dog.getId());
		assertEquals("Saint Bernard", dog.getSpecies());
	}

	@Test
	void readAllTest() {
		List<Dog> dogList = dogDatasourceImpl.readAll();
		assertEquals(6, dogList.size());
	}

	@Test
	void readByBirthDateGreaterThanTest() {
		List<Dog> dogList = dogDatasourceImpl.readByBirthDateGreaterThan(LocalDate.of(2018, 12, 12));
		assertEquals(3, dogList.size());
	}

	@Test
	void deleteTest() {
		assertTrue(dogDatasourceImpl.delete("111"));
	}
}

package com.acme.datasource.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;

import com.acme.datasource.model.Dog;
import com.acme.datasource.model.Gender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class DogDaoImplTest {

	@InjectMocks
	private DogDaoImpl dogDao;

	@Test
	void createTest() throws SQLException {
		Dog dog = new Dog();
		dog.setId("111");
		dog.setName("Jimmy");
		SimpleDateFormat date = new SimpleDateFormat();
		dog.setBirthDate(LocalDate.of(2020, 12, 12));
		dog.setSpecies("Siberian Husky");
		dog.setGender(Gender.M);
		assertTrue(dogDao.create(dog));
	}

	@Test
	void updateTest() throws SQLException {
		Dog dog = new Dog();
		dog.setId("111");
		dog.setName("Jimmy");
		dog.setBirthDate(LocalDate.of(2020, 12, 12));
		dog.setSpecies("Saint Bernard");
		dog.setGender(Gender.M);
		assertTrue(dogDao.update(dog));
	}

	@Test
	void readByIdTest() throws SQLException {
		Optional<Dog> optionalDog = dogDao.readById("111");
		Dog dog = optionalDog.orElseThrow();
		assertEquals("111", dog.getId());
		assertEquals("Saint Bernard", dog.getSpecies());
	}

	@Test
	void readAllTest() throws SQLException {
		List<Dog> dogList = dogDao.readAll();
		assertEquals(6, dogList.size());
	}

	@Test
	void readByBirthDateGreaterThanTest() throws SQLException {
		List<Dog> dogList = dogDao.readByBirthDateGreaterThan(LocalDate.of(2018, 12, 12));
		assertEquals(3, dogList.size());
	}

	@Test
	void deleteTest() throws SQLException {
		assertTrue(dogDao.delete("111"));
	}
}

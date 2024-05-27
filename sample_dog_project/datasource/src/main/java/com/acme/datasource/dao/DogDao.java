package com.acme.datasource.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.acme.datasource.model.Dog;

public interface DogDao {

	boolean create(Dog dog);

	boolean update(Dog dog);

	Optional<Dog> readById(String id);

	List<Dog> readAll();

	List<Dog> readByBirthDateGreaterThan(LocalDate date);

	boolean delete(String id);

}

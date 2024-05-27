package com.acme.datasource;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.acme.datasource.model.Dog;

public interface DogDatasource {

	void init();

	boolean create(Dog dog);

	boolean update(Dog dog);

	Optional<Dog> readById(String id);

	List<Dog> readAll();

	List<Dog> readByBirthDateGreaterThan(LocalDate date);

	boolean delete(String id);

}

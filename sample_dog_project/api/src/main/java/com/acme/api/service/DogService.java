package com.acme.api.service;

import com.acme.datasource.model.Dog;
import org.springframework.stereotype.Service;

import com.acme.datasource.DogDatasource;
import com.acme.datasource.DogDatasourceFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {

	private final DogDatasource dogDatasource;

	public DogService() {
		dogDatasource = DogDatasourceFactory.create();
	}

	public List<Dog> readAll(LocalDate date)
	{
		if(date == null) {
			return (List<Dog>) dogDatasource.readAll();
		}
		else{
			return (List<Dog>) dogDatasource.readByBirthDateGreaterThan(date);
		}
	}

	public Optional<Dog> readById(String id)
	{
		return dogDatasource.readById(id);
	}

	public boolean create(Dog dog)
	{
		return dogDatasource.create(dog);
	}

	public boolean update(String id, Dog updatedDog)
	{
		Optional<Dog> originalDog = dogDatasource.readById(id);
		Dog dog = originalDog.orElse(new Dog());
		dog.setId(id);
		dog.setName(updatedDog.getName());
		dog.setBirthDate(updatedDog.getBirthDate().toLocalDate());
		dog.setSpecies(updatedDog.getSpecies());
		dog.setGender(updatedDog.getGender());
		return dogDatasource.update(dog);
	}

	public boolean delete(String id)
	{
		return dogDatasource.delete(id);
	}
}

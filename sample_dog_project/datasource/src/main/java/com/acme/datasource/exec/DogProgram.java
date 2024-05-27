package com.acme.datasource.exec;

import java.time.LocalDate;
import java.util.List;

import com.acme.datasource.DogDatasource;
import com.acme.datasource.DogDatasourceFactory;
import com.acme.datasource.model.Dog;
import com.acme.datasource.model.Gender;

public class DogProgram {

	public static void main(String[] args) {
		DogDatasource dogDatasource = DogDatasourceFactory.create();

		// dog creation
		Dog scoobyDoo = new Dog();
		scoobyDoo.setName("Scooby Doo");
		scoobyDoo.setSpecies("Great Dane");
		scoobyDoo.setGender(Gender.X);
		scoobyDoo.setBirthDate(LocalDate.now());

		// it must print "true"
		System.out.println(dogDatasource.create(scoobyDoo));

		// it must print 6 dogs
		print(dogDatasource.readAll());

		var filteredDogs = dogDatasource.readByBirthDateGreaterThan(LocalDate.of(2020, 1, 1));

		// it must print 2 dogs
		print(filteredDogs);

		var retrievedDog = filteredDogs.get(0);
		retrievedDog.setBirthDate(LocalDate.of(2019, 1, 1));

		// it must print "true"
		System.out.println(dogDatasource.update(retrievedDog));

		filteredDogs = dogDatasource.readByBirthDateGreaterThan(LocalDate.of(2020, 1, 1));

		// it must print 1 dog
		print(filteredDogs);

		// it must print "true"
		System.out.println(dogDatasource.delete(filteredDogs.get(0).getId()));

		// it must print 0 dogs
		print(dogDatasource.readByBirthDateGreaterThan(LocalDate.of(2020, 1, 1)));

	}

	private static void print(List<Dog> dogs) {
		System.out.printf("\n| Number of dogs: %d\n", dogs.size());
		dogs.forEach(dog -> System.out.printf("|------> %s\n", dog));
		System.out.println();
	}

}

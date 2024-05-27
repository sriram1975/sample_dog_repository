package com.acme.datasource.reader.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.acme.datasource.impl.DogDatasourceImpl;
import com.acme.datasource.model.Dog;
import com.acme.datasource.model.Gender;
import com.acme.datasource.reader.DogReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DogReaderImpl implements DogReader {

	private static final Logger LOG = LoggerFactory.getLogger(DogReaderImpl.class);

	@Override
	public List<Dog> read() {
		String line = "";
		String splitBy = "	";
		List<Dog> dogList = new ArrayList<Dog>();
		Dog dog = null;
		try
		{
			//parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader("\\resources\\dogs.csv"));
			while ((line = br.readLine()) != null)   //returns a Boolean value
			{
				String[] dogTokens = line.split(splitBy);
				dog = new Dog();
				dog.setName(dogTokens[0]);
				dog.setBirthDate(LocalDate.parse(dogTokens[1]));
				dog.setSpecies(dogTokens[2]);
				dog.setGender(Gender.valueOf(dogTokens[3]));
				dogList.add(dog);
			}
		}
		catch (IOException e)
		{
			LOG.error("Cannot read from file");
		}

		return dogList;
	}
}

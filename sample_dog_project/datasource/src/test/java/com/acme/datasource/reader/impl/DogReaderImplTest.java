package com.acme.datasource.reader.impl;

import java.net.URISyntaxException;
import java.util.List;

import com.acme.datasource.model.Dog;
import com.acme.datasource.reader.DogReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DogReaderImplTest {

	@Test
	void readTest() throws URISyntaxException {
		DogReader dogReader = new DogReaderImpl();
		List<Dog> dogList = dogReader.read();
		assertEquals(5, dogList.size());
	}
}

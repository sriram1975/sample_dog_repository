package com.acme.datasource;

import java.net.URISyntaxException;

import com.acme.datasource.dao.DogDao;
import com.acme.datasource.dao.DogDaoImpl;
import com.acme.datasource.impl.DogDatasourceImpl;
import com.acme.datasource.reader.DogReader;
import com.acme.datasource.reader.impl.DogReaderImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DogDatasourceFactoryTest {

	@Test
	void createTest() throws URISyntaxException {
		DogDatasource dogDatasource = DogDatasourceFactory.create();

		DogReader dogReader = new DogReaderImpl();
		DogDao dogDao = new DogDaoImpl();
		DogDatasourceImpl dogDatasourceImpl = new DogDatasourceImpl(dogReader, dogDao);
		dogDatasourceImpl.init();
		assertEquals(dogDatasourceImpl, dogDatasource);
	}

}

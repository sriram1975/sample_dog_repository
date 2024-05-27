package com.acme.datasource;

import com.acme.datasource.dao.DogDao;
import com.acme.datasource.dao.DogDaoImpl;
import com.acme.datasource.impl.DogDatasourceImpl;
import com.acme.datasource.reader.DogReader;
import com.acme.datasource.reader.impl.DogReaderImpl;

public class DogDatasourceFactory {

	private static DogDatasource dogDatasource;

	private DogDatasourceFactory() {
	}

	public static DogDatasource create() {
		if (dogDatasource == null) {
			DogReader dogReader = new DogReaderImpl();
			DogDao dogDao = new DogDaoImpl();
			DogDatasourceImpl dogDatasourceImpl = new DogDatasourceImpl(dogReader, dogDao);
			dogDatasourceImpl.init();
			dogDatasource = dogDatasourceImpl;
		}
		return dogDatasource;
	}
}

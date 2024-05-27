package com.acme.datasource.dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DogDaoImplTest {

	@InjectMocks
	private DogDaoImpl dogDao;

	@Test
	void createTest() throws SQLException {

		
	}

	@Test
	void updateTest() throws SQLException {
		// TODO
	}

	@Test
	void readByIdTest() throws SQLException {
		// TODO
	}

	@Test
	void readAllTest() throws SQLException {
		// TODO
	}

	@Test
	void readByBirthDateGreaterThanTest() throws SQLException {
		// TODO
	}

	@Test
	void deleteTest() throws SQLException {
		// TODO
	}

}

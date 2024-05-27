package com.acme.datasource.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.datasource.DogDatasource;
import com.acme.datasource.dao.DogDao;
import com.acme.datasource.model.Dog;
import com.acme.datasource.reader.DogReader;

public class DogDatasourceImpl implements DogDatasource {

	private static final Logger LOG = LoggerFactory.getLogger(DogDatasourceImpl.class);

	private final DogReader dogReader;

	private final DogDao dogDao;

	public DogDatasourceImpl(DogReader dogReader, DogDao dogDao) {
		this.dogReader = dogReader;
		this.dogDao = dogDao;
	}

	public void init() {
		LOG.debug("init");
		dogReader.read().forEach(dog -> dogDao.create(dog));
	}

	@Override
	public boolean create(Dog dog) {
		LOG.debug("create");
		return dogDao.create(dog);
	}

	@Override
	public boolean update(Dog dog) {
		LOG.debug("update");
		return dogDao.update(dog);
	}

	@Override
	public Optional<Dog> readById(String id) {
		LOG.debug("readById");
		return dogDao.readById(id);
	}

	@Override
	public List<Dog> readAll() {
		LOG.debug("readAll");
		return dogDao.readAll();
	}

	@Override
	public List<Dog> readByBirthDateGreaterThan(LocalDate date) {
		LOG.debug("readByBirthDateGreaterThan");
		return dogDao.readByBirthDateGreaterThan(date);
	}

	@Override
	public boolean delete(String id) {
		LOG.debug("delete");
		return dogDao.delete(id);
	}
}
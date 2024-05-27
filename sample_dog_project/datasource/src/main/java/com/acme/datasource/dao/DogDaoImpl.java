package com.acme.datasource.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.acme.datasource.model.Gender;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.datasource.model.Dog;

public class DogDaoImpl implements DogDao {

	private static final Logger LOG = LoggerFactory.getLogger(DogDaoImpl.class);

	private static final String CONNECTION_STRING = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=CREATE TABLE IF NOT EXISTS DOG(ID UUID PRIMARY KEY,NAME VARCHAR(255) NOT NULL,BIRTH_DATE DATE NOT NULL,SPECIES VARCHAR(255) NOT NULL,GENDER CHAR(1) NOT NULL)";

	private static final String CREATE = "insert into Dog(name,birthdate,species,gender) values (?,?,?,?)";

	private static final String READ_BY_ID = "select * from Dog where id = ? ";

	private static final String READ_ALL = "select * from Dog";

	private static final String READ_BY_BIRTH_DATE_GREATER_THAN = "select * from dog where birthdate > ?";

	private static final String UPDATE = "update Dog set name = ?, birthdate = ?, species = ? gender = ? where id = ?";

	private static final String DELETE = "delete from dog where id = ?";

	@Override
	public boolean create(Dog dog) {
		LOG.debug("create");
        int i;
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1, dog.getName());
            ps.setDate(2, dog.getBirthDate());
            ps.setString(3, dog.getSpecies());
            ps.setString(4, dog.getGender().toString());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i > 0;
    }

	@Override
	public boolean update(Dog dog) {
		LOG.debug("update");
		int i;
		try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			 PreparedStatement ps = conn.prepareStatement(UPDATE)) {
			ps.setString(1, dog.getName());
			ps.setDate(2, dog.getBirthDate());
			ps.setString(3, dog.getSpecies());
			ps.setString(4, dog.getGender().toString());
			ps.setString(5, dog.getId());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return i > 0;
	}

	@Override
	public Optional<Dog> readById(String id) {
		LOG.debug("readById");
		try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			 PreparedStatement ps = conn.prepareStatement(READ_BY_ID)) {
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			Dog dog = new Dog();
			dog.setId(rs.getString(1));
			dog.setName(rs.getString(2));
			dog.setBirthDate(rs.getDate(3).toLocalDate());
			dog.setSpecies(rs.getString(4));
			dog.setGender(Gender.valueOf(rs.getString(5)));
			return Optional.of(dog);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Dog> readAll() {
		LOG.debug("readAll");
		return getDogs(READ_ALL);
	}

	@Override
	public List<Dog> readByBirthDateGreaterThan(LocalDate date) {
		LOG.debug("readByBirthDateGreaterThan");
		return getDogs(READ_BY_BIRTH_DATE_GREATER_THAN);
	}

	private List<Dog> getDogs(String readByBirthDateGreaterThan) {
		try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			 PreparedStatement ps = conn.prepareStatement(readByBirthDateGreaterThan)) {
			ResultSet rs = ps.executeQuery();
			Dog dog;
			List<Dog> dogList = new ArrayList<Dog>();
			while(rs.next()) {
				dog = new Dog();
				dog.setId(rs.getString(1));
				dog.setName(rs.getString(2));
				dog.setBirthDate(rs.getDate(3).toLocalDate());
				dog.setSpecies(rs.getString(4));
				dog.setGender(Gender.valueOf(rs.getString(5)));
				dogList.add(dog);
			}
			return dogList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delete(String id) {
		LOG.debug("delete");
		int i;
		try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			 PreparedStatement ps = conn.prepareStatement(DELETE)) {
			ps.setString(1, id);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return i > 0;
	}
}
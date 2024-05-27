package com.acme.datasource.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Dog {

	private String id;

	private String name;

	private LocalDate birthDate;

	private String species;

	private Gender gender;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() { return Date.valueOf(birthDate); }

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return String.format("Dog(id=%s, name=%s, birthDate=%s, species=%s, gender=%s)", id, name, birthDate, species,
				gender);
	}

}
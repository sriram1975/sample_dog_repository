# Creation of a Datasource lib (2 hours)

A dog datasource jar has to be created.

The library must use a relational in-memory database (h2).

It must provide all the basic operations to **Create**, **Read**, **Update** and **Delete** dogs from the DB.

The required operations must be the following:

```
boolean create(Dog dog)

boolean update(Dog dog)

Optional<Dog> readById(String id)

List<Dog> readAll()

List<Dog> readByBirthDateGreaterThan(LocalDate date)

boolean delete(String id)
```
A starting code for the DAO class is already provided, it doesn't use JPA implememntations. JPA can be used as alternative.

In order to check if everything works as expected, DogProgram class was created. It contains a main method that must print the following:

```
true

| Number of dogs: 6
|------> Dog(id=..., name=Balto, birthDate=2021-08-31, species=Siberian Husky, gender=M)
|------> Dog(id=..., name=Beethoven, birthDate=2019-04-27, species=Saint Bernard, gender=M)
|------> Dog(id=..., name=Rex, birthDate=2018-03-12, species=German Shepherd, gender=M)
|------> Dog(id=..., name=Rin Tin Tin, birthDate=2015-07-16, species=German Shepherd, gender=M)
|------> Dog(id=..., name=Lassie, birthDate=2018-05-23, species=Rough Collie, gender=F)
|------> Dog(id=..., name=Scooby Doo, birthDate=2022-05-05, species=Great Dane, gender=X)


| Number of dogs: 2
|------> Dog(id=..., name=Balto, birthDate=2021-08-31, species=Siberian Husky, gender=M)
|------> Dog(id=..., name=Scooby Doo, birthDate=2022-05-05, species=Great Dane, gender=X)

true

| Number of dogs: 1
|------> Dog(id=..., name=Scooby Doo, birthDate=2022-05-05, species=Great Dane, gender=X)

true

| Number of dogs: 0

```

Unit tests are required.

Validation of the inputs is a big plus

[go to Assessment (max 5 hours)](../README.md)
# Creation of a Springboot api (2 hours)

A dogs REST API Springboot based has to be created.

The required operations must be the following:

| URL | POST | GET | PUT | DELETE |
| ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ |
| http://localhost:{port}/dogs | it create a new dog if a dog is provided in the http body request | if date is not specified as query (?date=yyyy-MM-dd), it returns the entire list of dogs otherwise it returns all the dogs younger than the selected date | not supported  | not supported |
| http://localhost:{port}/dogs/{id} | not supported | it returns the dog by specified id | it updates the dog by specified id and request body | it deletes the dog by specified id |

The application should run under two profiles:
* a default profile with port 8000
* a prod profile with port 8080

Unit tests are required.

Validation of the inputs is a big plus

[go to Assessment (max 5 hours)](../README.md)

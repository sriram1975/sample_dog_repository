# Creation of a Dockerized api (1 hour)

After building the api project, the antrun plugin copies the produced jar in the docker project.

The jar must be the starting point.

A docker image called test has to be created.

```
docker build -t test .
```

The image has to be created from a jdk11 image, for instance:

```
FROM openjdk:11-jre-slim-buster
```

After the creation of the test image, two working containers can be raised using the following commands:

```
docker run -e "env=test" -p 8000:8000 --name test_container -t test
docker run -e "env=prod" -p 8080:8080 --name prod_container -t test
```

The image has to be set to accept and environment variable called $env . The exposed port is depending by its value;

[go to Assessment (max 5 hours)](../README.md)
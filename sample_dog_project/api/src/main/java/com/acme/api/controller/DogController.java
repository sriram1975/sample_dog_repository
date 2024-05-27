package com.acme.api.controller;

import com.acme.api.service.DogService;
import com.acme.datasource.model.Dog;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dogs")
public class DogController {

  private final DogService dogService;

  public DogController(DogService dogService) {
    this.dogService = dogService;
  }

  @GetMapping
  public ResponseEntity<List<Dog>> readAll(
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

    List<Dog> list = dogService.readAll(date);
    return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Dog> readById(@PathVariable String id) {
    Optional<Dog> dog = dogService.readById(id);
    return new ResponseEntity<Dog>(dog.get(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Dog> create(@RequestBody Dog dog) {
    boolean flag = dogService.create(dog);
    if(flag)
    {
      return new ResponseEntity<Dog>(dog, HttpStatus.OK);
    }
    return null;
  }

  @PutMapping("/{id}")
  public ResponseEntity<Dog> update(@PathVariable String id, @RequestBody Dog dog) {
    boolean flag = dogService.update(id, dog);
    if(flag)
    {
      return new ResponseEntity<Dog>(dog, HttpStatus.OK);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    boolean flag = dogService.delete(id);
    if(flag)
    {
      return new ResponseEntity<Void>(HttpStatus.OK);
    }
    return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
  }

}

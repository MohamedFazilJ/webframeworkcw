package com.example.springapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Person;
import com.example.springapp.service.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    // @SuppressWarnings("rawtypes")
    @PostMapping("/api/person")
    public ResponseEntity<Person> postMethodName(@RequestBody Person person) {
        if(personService.postPerson(person)==true)
        {
            return new ResponseEntity<>(person,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/person")
    public ResponseEntity<List<Person>> getMethodname() {
        List<Person> listPerson = personService.personList();
        if (listPerson.size() > 0) {
            return new ResponseEntity<>(listPerson,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    

    @GetMapping("/api/person/byAge")
    public ResponseEntity<List<Person>> getMethodname(@RequestParam int age) {
        List<Person> listPerson = personService.findAge(age);
        if (listPerson.size() > 0) {
            return new ResponseEntity<>(listPerson,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
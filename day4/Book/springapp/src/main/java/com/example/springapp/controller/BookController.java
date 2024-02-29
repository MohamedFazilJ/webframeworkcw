package com.example.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Book;
import com.example.springapp.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
    
    private BookService patientServices;
    public BookController(BookService patientServices)
    {
        this.patientServices = patientServices;
    }

    @PostMapping("/patient")
    public ResponseEntity<Book> addData(@RequestBody Book patient)
    {
        if(patientServices.addPatient(patient))
        {
            return new ResponseEntity<Book>(patient, HttpStatus.CREATED);
        }
        else{
            System.out.println("Cannot add Object");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patient")
    public ResponseEntity<List<Book>> getList()
    {
        List<Book> patients = patientServices.getPatients();
        if(patients.size() > 0)
        {
            return new ResponseEntity<List<Book>>(patients, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<Book> getpatientById(@PathVariable int patientId){
        Book patient = patientServices.getPatientById(patientId);
        if(patient != null)
        {
            return new ResponseEntity<Book>(patient, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
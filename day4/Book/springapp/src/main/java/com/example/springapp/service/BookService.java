package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.springapp.model.Book;
import com.example.springapp.repository.BookRepo;

@Service
public class BookService {
    
    @Autowired
    private BookRepo patientRepo;

    public boolean addPatient(Book patient)
    {
        try{
            patientRepo.save(patient);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Book> getPatients()
    {
        return patientRepo.findAll();
    }

    public Book getPatientById(int patientId)
    {
        return patientRepo.findById(patientId).orElse(null);
    }
}
package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Person;
import com.example.springapp.repository.PersonRepo;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;
   // @SuppressWarnings("unchecked")
    public boolean postPerson(Person person)
    {
        try
        {
            personRepo.save(person);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

   // @SuppressWarnings("unchecked")
    public List<Person> personList()
    {
        return personRepo.findAll();
    }
    public List<Person> findAge(int age)
    {
        return personRepo.findByAge(age);
    }
}

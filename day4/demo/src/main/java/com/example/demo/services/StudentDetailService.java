package com.example.demo.services;

import java.util.Optional;
import java.util.*;

import org.springframework.stereotype.Service;

import com.example.demo.model.StudentDetails;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentDetailService {
    
    private StudentRepository rep;
    public StudentDetailService(StudentRepository rep)
    {
        this.rep=rep;
    }
    public StudentDetails save(StudentDetails stu)
    {
        return rep.save(stu);
    }
    public StudentDetails abcd(int id)
    {
        Optional<StudentDetails> optionalMedicine = rep.findById(id);
        return optionalMedicine.orElse(null);
    }

    public List<StudentDetails> efgh()
    {
        return rep.findAll();
    }
}

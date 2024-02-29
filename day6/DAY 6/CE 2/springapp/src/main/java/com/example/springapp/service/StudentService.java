package com.example.springapp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Student;
import com.example.springapp.repository.StudentRepo;

@Service
public class StudentService {
    
    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo)
    {
        this.studentRepo = studentRepo;
    }

    public boolean postStudent(Student student)
    {
        try{
            studentRepo.save(student);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Student> getSortedPages(int pageNo, int pageSize, String sortBy)
    {
        return studentRepo.findAll(PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, sortBy))).getContent();
    }
    
    public List<Student> getPages(int pageNo,int pageSize)
    {
        return studentRepo.findAll(PageRequest.of(pageNo,pageSize)).getContent();
    }
}

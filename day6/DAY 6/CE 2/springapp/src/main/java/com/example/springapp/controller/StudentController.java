package com.example.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Student;
import com.example.springapp.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
    
    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<Student> postStudent(@RequestBody Student student)
    {
        if(studentService.postStudent(student))
            return new ResponseEntity<>(student,HttpStatus.CREATED);
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getPages(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize)
    {
        List<Student> studentList = studentService.getPages(pageNo, pageSize);
        if(!studentList.isEmpty())
        {
            return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ GetMapping("/student/sort")
    public ResponseEntity<List<Student>> getSortedPages(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize, @RequestParam("sortBy") String sortBy){
        List<Student> studentList = studentService.getSortedPages(pageNo, pageSize, sortBy);
        if(!studentList.isEmpty())
        {
            return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

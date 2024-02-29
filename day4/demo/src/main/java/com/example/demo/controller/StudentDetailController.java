package com.example.demo.controller;
import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentDetails;
import com.example.demo.services.StudentDetailService;


@RestController
public class StudentDetailController {

    // using autowired is known as field injection
    // @Autowired
    private StudentDetailService ser;
    //this method is known as constructor injection
    public StudentDetailController(StudentDetailService ser)
    {
        this.ser=ser;
    }
    @PostMapping("/student")
    public StudentDetails add(@RequestBody StudentDetails entity) {
        ser.save(entity);
       return entity;
    }

    @RequestMapping("/stu")
    public StudentDetails abc(@RequestParam int id)
    {
        return ser.abcd(id);
    }


    @RequestMapping("/stud")
    public List<StudentDetails> efg()
    {
        return ser.efgh();
    }
    
}

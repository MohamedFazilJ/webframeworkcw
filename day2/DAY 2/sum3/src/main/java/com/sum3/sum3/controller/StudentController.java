package com.sum3.sum3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sum3.sum3.model.Student;

@RestController
public class StudentController {
    @Autowired
    Student stu;

    public Student abc()
    {
        return stu;
    }
}

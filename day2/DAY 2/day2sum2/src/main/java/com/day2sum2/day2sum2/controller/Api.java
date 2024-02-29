package com.day2sum2.day2sum2.controller;

public class Api {
    
}
package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Student;

@RestController
public class StudentController {
    @Autowired
    private Student s;
    @PostMapping("/students")
    public Student abc()
    {
        return s;
    }
    
}

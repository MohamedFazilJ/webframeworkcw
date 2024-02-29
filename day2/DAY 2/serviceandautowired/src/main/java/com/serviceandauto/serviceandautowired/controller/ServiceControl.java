package com.serviceandauto.serviceandautowired.controller;


import org.springframework.web.bind.annotation.RestController;

import com.serviceandauto.serviceandautowired.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

import com.serviceandauto.serviceandautowired.model.StudentModel;


@RestController
public class ServiceControl {

    @Autowired
    private BusinessService Service;

    @GetMapping("/path")
    public List<StudentModel> getStudents() {
        Service.students.add(new StudentModel("Pavi", "126"));
        Service.students.add(new StudentModel("Parthi", "125"));
        Service.students.add(new StudentModel("Nivash", "124"));

        return Service.students;
    }
}
package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Employee;
import com.example.springapp.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService ser;

     @PostMapping( "/api/employee")
    public ResponseEntity<Employee> add (@RequestBody Employee pro)
    {
        if(ser.add(pro))
        {
            return new ResponseEntity<Employee>(pro,HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



     @PutMapping("/api/employee/{employeeId}")
    public ResponseEntity<Employee> update (@RequestParam int userName,@RequestBody Employee signUp)
    {
        Employee employee = ser.update(userName, signUp);
        if(employee==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<Employee>(employee,HttpStatus.OK);
        }
    }



    @DeleteMapping("/api/employee/{employeeId}")
    public ResponseEntity<Employee> deleteById(@PathVariable int userName)
    {
        Employee employee = ser.deleteByName(userName);
        if(employee!=null)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}

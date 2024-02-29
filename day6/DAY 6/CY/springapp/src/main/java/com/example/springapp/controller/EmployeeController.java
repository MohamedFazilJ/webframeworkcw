package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Employee;
import com.example.springapp.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService ser;

    @PostMapping("/api/employee")
    public ResponseEntity<Employee> abc(@RequestBody Employee employee)
    {
        if(ser.post(employee))
        {
            return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/employee/sortBy/{field}")
    public ResponseEntity<List<Employee>> xyz (@PathVariable String field)
    {
        List<Employee> li = ser.get1(field);
        if(li.size()>0)
        {
            return new ResponseEntity<List<Employee>>(li,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/api/employee/{offset}/{pagesize}")
    public ResponseEntity<List<Employee>> vfg(@PathVariable int offset,@PathVariable int pagesize)
    {
        List<Employee> li = ser.get2(offset,pagesize);
        if(!li.isEmpty())
        {
            return new ResponseEntity<List<Employee>>(li,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/api/employee/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Employee>> abcf(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        List<Employee> li = ser.get3(offset, pagesize, field);
        if(!li.isEmpty())
        {
            return new ResponseEntity<List<Employee>>(li,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    
}

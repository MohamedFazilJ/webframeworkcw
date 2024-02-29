package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.springapp.model.Employee;
import com.example.springapp.repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo rep;

    public boolean post(Employee employee)
    {
        try
        {
            rep.save(employee);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Employee> get1(String a)
    {
        return rep.findAll(Sort.by(Sort.Direction.ASC,a));
    }

    public List<Employee> get2(int a,int b)
    {
        return rep.findAll(PageRequest.of(a, b)).getContent();
    }


    public List<Employee> get3(int a,int b,String c)
    {
        return rep.findAll(PageRequest.of(a, b,Sort.by(Sort.Direction.ASC,c))).getContent();
    }

    
}

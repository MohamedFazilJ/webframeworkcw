package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Employee;
import com.example.springapp.repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo rep;

    public boolean add(Employee pro) {
        try {
            rep.save(pro);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Employee getByIdToDelete(int userName) {
        return rep.findById(userName).orElse(null);

    }

    public Employee update(int userName, Employee signUp) {
        Employee employee = getByIdToDelete(userName);
        if (employee == null) {
            return null;
        }
        try {
            rep.save(signUp);
            return employee;
        } catch (Exception e) {
            return null;
        }
    }

    public Employee deleteByName(int userName) {
        Employee employee = getByIdToDelete(userName);
        if (employee == null) {
            return null;
        }
        rep.deleteById(userName);
        return employee;
    }

}

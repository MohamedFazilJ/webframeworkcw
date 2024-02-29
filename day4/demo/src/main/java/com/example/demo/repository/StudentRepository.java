package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentDetails;

// change class to interface
// add extend JpaRepository <object, datatype of primary key>
@Repository
public interface StudentRepository extends JpaRepository<StudentDetails , Integer>{
    
}

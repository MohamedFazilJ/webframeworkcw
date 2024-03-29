package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Course;

@Repository

public interface CourseRepo extends JpaRepository<Course, Integer> {

    List<Course> findBycourseName(String courseName);

}

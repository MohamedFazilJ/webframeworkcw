package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Course;
import com.example.springapp.repository.CourseRepo;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    // @SuppressWarnings("unchecked")
    public boolean postCourse(Course course) {
        try {
            courseRepo.save(course);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // @SuppressWarnings("unchecked")
    public List<Course> CourseList() {
        return courseRepo.findAll();
    }

    public List<Course> findcourseName(String courseName) {
        return courseRepo.findBycourseName(courseName);
    }
}

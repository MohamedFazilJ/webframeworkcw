package com.example.springapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Course;
import com.example.springapp.service.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    // @SuppressWarnings("rawtypes")
    @PostMapping("/api/Course")
    public ResponseEntity<Course> postMethodName(@RequestBody Course course) {
        if (courseService.postCourse(course) == true) {
            return new ResponseEntity<>(course, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/Course")
    public ResponseEntity<List<Course>>getMethodname() {
        List<Course> listCourse = courseService.CourseList();
        if (listCourse.size() > 0) {
            return new ResponseEntity<>(listCourse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/Course/{courseName}")
    public ResponseEntity<List<Course>> getMethodname(@RequestParam String courseName) {
        List<Course> listCourse = courseService.findcourseName(courseName);
        if (listCourse.size() > 0) {
            return new ResponseEntity<>(listCourse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
package com.example.challenge_yourself_1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.challenge_yourself_1.model.Family;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FamilyController {

     @GetMapping("/path")
     public Family getMethodName() {
          Family f = new Family("John", 20, "Brother");
          return f;
     }

}

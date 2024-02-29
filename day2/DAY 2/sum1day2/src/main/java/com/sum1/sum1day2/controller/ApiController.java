package com.sum1.sum1day2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sum1.sum1day2.config.AppConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class ApiController {
    @Autowired
    AppConfig p;
    @RequestMapping("/path")
    public String requestMethodName() {
        return p.getAppName() + "   " + p.getAppVersion();
    }   
}

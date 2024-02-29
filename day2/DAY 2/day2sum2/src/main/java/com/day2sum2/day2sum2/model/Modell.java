package com.day2sum2.day2sum2.model;

public class Modell {
    
}
package com.examly.springapp.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Student {
    @JsonProperty("Created")
    private String name;
    @JsonProperty("Age")
    private int age;

    public Student(){}
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    
}

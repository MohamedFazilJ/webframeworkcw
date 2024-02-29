package com.serviceandauto.serviceandautowired.model;


public class StudentModel {
    private String name;
    private String RollNumber;

    public StudentModel(String name, String rollNumber) {
        this.name = name;
        RollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return RollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(String rollNumber) {
        RollNumber = rollNumber;
    }
}
    


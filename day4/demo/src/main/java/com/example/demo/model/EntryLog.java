package com.example.demo.model;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EntryLog {
    @Id
    private String rollNo;
    private Date entry;

    public EntryLog(){}
    public EntryLog(String rollNo, Date entry) {
        this.rollNo = rollNo;
        this.entry = entry;
    }
    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
    public Date getEntry() {
        return entry;
    }
    public void setEntry(Date entry) {
        this.entry = entry;
    }


    
    
}

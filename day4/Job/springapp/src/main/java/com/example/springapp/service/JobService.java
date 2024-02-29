package com.example.springapp.service;
import com.example.springapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.springapp.repository.JobRepo;

@Service
public class JobService {

    @Autowired
    private JobRepo rep;
    
    @SuppressWarnings("null")
    public boolean addJob(Job job) {
        try{    
            rep.save(job);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public List<Job> getall()
    {
        return rep.findAll();
    }
    public Optional<Job> findById(int id)
    {
        return rep.findById(id);
    }
}

package com.example.springapp.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springapp.model.*;
import com.example.springapp.service.JobService;
import java.util.*;
@RestController
public class JobController {

    @Autowired
    private JobService ser;

    @PostMapping("/api/job")
    public ResponseEntity<Job> postjob(@RequestBody Job job)
    {
        if(ser.addJob(job))
        {
            return new ResponseEntity<>(job, HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }


    @GetMapping("/api/job")
    public ResponseEntity<List<Job>> getJob()
    {
        List<Job> jb = ser.getall();
        if(jb.size() > 0)
        {
            return new ResponseEntity<List<Job>>(jb, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


     @GetMapping("/api/job/{jobId}")
    public ResponseEntity<Optional<Job>> findJ(@PathVariable int jobId)
    {
        Optional<Job> jo = ser.findById(jobId);

        if(!jo.isEmpty())
        {
            return new ResponseEntity<Optional<Job>>(jo, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }   
    
}

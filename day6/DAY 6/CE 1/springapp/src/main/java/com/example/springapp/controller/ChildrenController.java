package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Children;
import com.example.springapp.service.ChildrenService;

@RestController
public class ChildrenController {
    @Autowired
    private ChildrenService ser;

    @PostMapping("/api/children")
    public ResponseEntity<Children> abc(@RequestBody Children children)
    {
        if(ser.post(children))
        {
            return new ResponseEntity<Children>(children,HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/children/sortBy/{field}")
    public ResponseEntity<List<Children>> xyz (@PathVariable String field)
    {
        List<Children> li = ser.get1(field);
        if(li.size()>0)
        {
            return new ResponseEntity<List<Children>>(li,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/api/children/{offset}/{pagesize}")
    public ResponseEntity<List<Children>> vfg(@PathVariable int offset,@PathVariable int pagesize)
    {
        List<Children> li = ser.get2(offset,pagesize);
        if(!li.isEmpty())
        {
            return new ResponseEntity<List<Children>>(li,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/api/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Children>> abcf(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        List<Children> li = ser.get3(offset, pagesize, field);
        if(!li.isEmpty())
        {
            return new ResponseEntity<List<Children>>(li,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    
}

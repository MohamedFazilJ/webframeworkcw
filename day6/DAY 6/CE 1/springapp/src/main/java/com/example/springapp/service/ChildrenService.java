package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.springapp.model.Children;
import com.example.springapp.repository.ChildrenRepo;

@Service
public class ChildrenService {
    @Autowired
    private ChildrenRepo rep;

    public boolean post(Children children)
    {
        try
        {
            rep.save(children);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Children> get1(String a)
    {
        return rep.findAll(Sort.by(Sort.Direction.ASC,a));
    }

    public List<Children> get2(int a,int b)
    {
        return rep.findAll(PageRequest.of(a, b)).getContent();
    }


    public List<Children> get3(int a,int b,String c)
    {
        return rep.findAll(PageRequest.of(a, b,Sort.by(Sort.Direction.ASC,c))).getContent();
    }

    
}

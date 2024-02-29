package com.example.springapp.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Product;
import com.example.springapp.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo rep;

    @SuppressWarnings("null")
    public boolean add(Product pro)
    {
        try{
            rep.save(pro);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    
    public List<Product> find()
    {
        return rep.findAll();
    }

    public Optional<Product> findId(int id)
    {
        return rep.findById(id);
    }
}

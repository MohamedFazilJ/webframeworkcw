package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.springapp.model.Product;
import com.example.springapp.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService ser;

    @PostMapping("/product")
    public ResponseEntity<Product> abc(@RequestBody Product pro) {
        if (ser.add(pro)) {
            return new ResponseEntity<Product>(pro, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> xyz() {
        List<Product> li = ser.find();
        if (li.size() > 0) {
            return new ResponseEntity<List<Product>>(li, HttpStatus.OK);
        } else 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Optional<Product>> def(@PathVariable int productId)
    {
        Optional<Product> pod = ser.findId(productId);

        if(!pod.isEmpty())
        {
            return new ResponseEntity<Optional<Product>>(pod, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
}

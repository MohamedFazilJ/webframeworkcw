package com.sum4.sum4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sum4.sum4.model.*;
@RestController

public class BookController {
   
@Autowired
private Book b;
@GetMapping("/book")
public Book abc()
{
    return b;
}
    

}

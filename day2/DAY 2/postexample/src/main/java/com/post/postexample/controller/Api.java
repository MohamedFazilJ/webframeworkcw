package com.post.postexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.post.postexample.model.Modell;

// to post the data in the form of JSON

@RestController
public class Api {
    @Autowired
    private Modell mod;
    @PostMapping("/path")
    public Modell Post(@RequestBody Modell entity)
    {
        mod.setId(entity.getId());
        mod.setName(entity.getName());
        return entity;
    }
}





/// to post the data in the form of text


// @RestController
// public class Api {
//     @PostExchange("/path")
//     public String dfg(@RequestBody String entity)
//     {
//         return entity + " received";
//     }
    
// }

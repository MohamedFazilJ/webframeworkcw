package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Language;
import com.example.springapp.service.LanguageService;

@RestController
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @PostMapping("/language")
    public ResponseEntity<Language> saveLanguage(@RequestBody Language language){

        if(languageService.saveLanguage(language))
        {
            return new ResponseEntity<Language>(language, HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<Language>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/language")
    public ResponseEntity<List<Language>> getLanguage(){
        List<Language> list = languageService.getLanguage();
        if(list.size() > 0)
        {
            return new ResponseEntity<List<Language>>(list, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<List<Language>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/language/{languageId}")
    public ResponseEntity<Language> serchByLanguageId(@PathVariable int languageId){
        Language language = languageService.serchByLanguageId(languageId);
        if(language != null)
        {
            return new ResponseEntity<Language>(language, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Language>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/language/{languageId}")
    public ResponseEntity<Language> updateLanguage(@PathVariable("languageId") int languageId, @RequestBody Language language){
        Language language1 = languageService.updateLanguage(languageId, language);
        if(language1 != null)
        {
            return new ResponseEntity<Language>(language1, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Language>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/language/{languageId}")
    public ResponseEntity<Language> deleteLanguage(@PathVariable("languageId") int languageId){
        Language language = languageService.deleteLanguage(languageId);
        if(language != null)
        {
            return new ResponseEntity<Language>(language, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Language>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

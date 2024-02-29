package com.example.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Language;
import com.example.springapp.service.LanguageService;

@RestController
@RequestMapping("/api")
public class LanguageController {
    
    private LanguageService languageService;
    public LanguageController(LanguageService languageService)
    {
        this.languageService = languageService;
    }

    @PostMapping("/language")
    public ResponseEntity<Language> addLanguage(@RequestBody Language language)
    {
        if(languageService.addLanguage(language))
        {
            return new ResponseEntity<Language>(language, HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/language/sortBy/{field}")
    public ResponseEntity<List<Language>> sortByField(@PathVariable("field") String field)
    {
        List<Language> language = languageService.sortLanguages(field);
        if(language.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<Language>>(language, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/language/{offset}/{pagesize}")
    public ResponseEntity<List<Language>> getPages(@PathVariable("offset") int offset, @PathVariable("pagesize") int pagesize)
    {
        List<Language> language = languageService.getPages(offset, pagesize);
        if(language.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<Language>>(language, HttpStatus.OK);
        }
    }

    @GetMapping("/language/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Language>> getSortedPages(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize,@PathVariable("field") String field)
    {
        List<Language> pages = languageService.getLanguages(offset, pagesize, field);

        if(pages.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<Language>>(pages, HttpStatus.OK);
        }
    }
}

package com.example.springapp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Language;
import com.example.springapp.repository.LanguageRepo;

@Service
public class LanguageService {
    
    private LanguageRepo languageRepo;
    public LanguageService(LanguageRepo languageRepo)
    {
        this.languageRepo = languageRepo;
    }

    public boolean addLanguage(Language language)
    {
        try{
            languageRepo.save(language);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public List<Language> getPages(int offset, int pageSize)
    {
        return languageRepo.findAll(PageRequest.of(offset, pageSize)).getContent();
    }

    public List<Language> sortLanguages(String field)
    {
        return languageRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    public List<Language> getLanguages(int offset, int pageSize, String field)
    {
        return languageRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, field))).getContent();
    }
}

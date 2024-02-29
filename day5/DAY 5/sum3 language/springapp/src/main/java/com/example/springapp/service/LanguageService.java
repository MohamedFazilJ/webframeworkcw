package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Language;
import com.example.springapp.repository.LanguageRepo;

@Service
public class LanguageService{

    @Autowired
    private LanguageRepo languageRepo;

    public Boolean saveLanguage(Language language)
    {
        try{
            languageRepo.save(language);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<Language> getLanguage()
    {
        return languageRepo.findAll();
    }

    public Language serchByLanguageId(int languageId)
    {
        return languageRepo.findById(languageId).orElse(null);
    }

    public Language deleteLanguage(int languageId)
    {
        Language language = this.serchByLanguageId(languageId);
        if(language == null)
        {
            return null;
        }

        try{
            languageRepo.deleteById(languageId);
            return language;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public Language updateLanguage(int languageId, Language language)
    {
        Language language1 = this.serchByLanguageId(languageId);
        if(language1 == null)
        {
            return null;
        }

        try{
            languageRepo.save(language);
            return language;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
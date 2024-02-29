package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.springapp.model.Patient;
import com.example.springapp.repository.PatientRepo;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepo patientRepo;

    public boolean addPatient(Patient patient)
    {
        try{
            patientRepo.save(patient);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Patient> getPatients()
    {
        return patientRepo.findAll();
    }

    public Patient getPatientById(int patientId)
    {
        return patientRepo.findById(patientId).orElse(null);
    }
}
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

import java.util.List;
import java.util.Optional;

import com.example.springapp.model.Medicine;
import com.example.springapp.service.MedicineService;


@RestController
@RequestMapping("/api")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @PostMapping("/medicine")
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) 
    {
        if(medicineService.addMedicine(medicine))
        {
            return new ResponseEntity<>(medicine, HttpStatus.CREATED);
        }
        else
        {
            System.out.println("Error in adding medicine");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }

    @GetMapping("/medicines")
    public ResponseEntity<List<Medicine>> getMedicines()
    {
        List<Medicine> medicines = medicineService.getMedicines();
        if(medicines.size() > 0)
        {
            return new ResponseEntity<List<Medicine>>(medicines, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/medicine/{medicineId}")
    public ResponseEntity<Optional<Medicine>> findMedicine(@PathVariable int medicineId)
    {
        Optional<Medicine> medicine = medicineService.findMedicineById(medicineId);

        if(!medicine.isEmpty())
        {
            return new ResponseEntity<Optional<Medicine>>(medicine, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }   
}
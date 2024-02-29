package com.example.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Medicine {
    @Id
    private int medicineId;
    private String MedicineName;
    private String medicineFor;
    private String medicineType;
    private String medicineBrand;
    private String manufractedIn;
    private double medicinePrice;
    private String expiryDate;
    
    public Medicine() {
    }
    public Medicine(int medicineId, String medicineName, String medicineFor, String medicineType, String medicineBrand,
            String manufractedIn, double medicinePrice, String expiryDate) {
        this.medicineId = medicineId;
        MedicineName = medicineName;
        this.medicineFor = medicineFor;
        this.medicineType = medicineType;
        this.medicineBrand = medicineBrand;
        this.manufractedIn = manufractedIn;
        this.medicinePrice = medicinePrice;
        this.expiryDate = expiryDate;
    }
    public int getMedicineId() {
        return medicineId;
    }
    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }
    public String getMedicineName() {
        return MedicineName;
    }
    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }
    public String getMedicineFor() {
        return medicineFor;
    }
    public void setMedicineFor(String medicineFor) {
        this.medicineFor = medicineFor;
    }
    public String getMedicineType() {
        return medicineType;
    }
    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }
    public String getMedicineBrand() {
        return medicineBrand;
    }
    public void setMedicineBrand(String medicineBrand) {
        this.medicineBrand = medicineBrand;
    }
    public String getManufractedIn() {
        return manufractedIn;
    }
    public void setManufractedIn(String manufractedIn) {
        this.manufractedIn = manufractedIn;
    }
    public double getMedicinePrice() {
        return medicinePrice;
    }
    public void setMedicinePrice(double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    
}
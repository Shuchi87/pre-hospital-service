package com.example.pre_hospitalservicesandsupplies;

import java.io.Serializable;

public class MedicinelistCode1 {

    String med,det,mprice,medicine;

    public MedicinelistCode1(String med, String det, String mprice) {
        this.med = med;
        this.det = det;
        this.mprice = mprice;
        this.medicine = medicine;
    }

    public MedicinelistCode1() {
    }


    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public String getDet() {
        return det;
    }

    public void setDet(String det) {
        this.det = det;
    }

    public String getMprice() {
        return mprice;
    }

    public void setMprice(String mprice) {
        this.mprice = mprice;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
}

package com.example.pre_hospitalservicesandsupplies;

import android.widget.EditText;

public class MedicineInsert {
    String med;
    String det;
    String mprice;

    public MedicineInsert(String med, String det, String mprice) {
        this.med = med;
        this.det = det;
        this.mprice =mprice;
    }

    public String getMed() {
        return med;
    }

    public String getDet() {
        return det;
    }

    public String getMprice(){
        return mprice;
    }
}

package com.example.pre_hospitalservicesandsupplies;

public class insertTRT {
    String adddiseasename;
    String addtreatment;
    String adddiseasedetection;

    public insertTRT(String adddiseasename, String addtreatment, String adddiseasedetection) {
        this.adddiseasename = adddiseasename;
        this.addtreatment = addtreatment;
        this.adddiseasedetection =adddiseasedetection;
    }


    public String getAdddiseasename() {
        return adddiseasename;
    }

    public String getAddtreatment() {
        return addtreatment;
    }

    public String getAdddiseasedetection() {
        return adddiseasedetection;
    }
}

package com.example.pre_hospitalservicesandsupplies;

public class DiseaseAndTreatementcode1 {

    String adddiseasename,addtreatment,adddiseasedetection,disease;

    public DiseaseAndTreatementcode1(String adddiseasename, String addtreatment, String adddiseasedetection, String disease) {
        this.adddiseasename = adddiseasename;
        this.addtreatment = addtreatment;
        this.adddiseasedetection = adddiseasedetection;
        this.disease = disease;
    }
    public DiseaseAndTreatementcode1(){

    }

    public String getAdddiseasename() {
        return adddiseasename;
    }

    public void setAdddiseasename(String adddiseasename) {
        this.adddiseasename = adddiseasename;
    }

    public String getAddtreatment() {
        return addtreatment;
    }

    public void setAddtreatment(String addtreatment) {
        this.addtreatment = addtreatment;
    }

    public String getAdddiseasedetection() {
        return adddiseasedetection;
    }

    public void setAdddiseasedetection(String adddiseasedetection) {
        this.adddiseasedetection = adddiseasedetection;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}

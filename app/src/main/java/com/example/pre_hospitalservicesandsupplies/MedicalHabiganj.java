package com.example.pre_hospitalservicesandsupplies;

public class MedicalHabiganj {

    private String addMedicalName;
    private String addDesignation;
    private String addDocotorName;
    private String addSerialNumber;
    private String addTime;

    public MedicalHabiganj(String addMedicalName, String addDesignation, String addDocotorName, String addSerialNumber, String addTime) {
        this.addMedicalName = addMedicalName;
        this.addDesignation = addDesignation;
        this.addDocotorName = addDocotorName;
        this.addSerialNumber = addSerialNumber;
        this.addTime = addTime;
    }

    public MedicalHabiganj() {
    }

    public String getAddMedicalName() {
        return addMedicalName;
    }

    public void setAddMedicalName(String addMedicalName) {
        this.addMedicalName = addMedicalName;
    }

    public String getAddDesignation() {
        return addDesignation;
    }

    public void setAddDesignation(String addDesignation) {
        this.addDesignation = addDesignation;
    }

    public String getAddDocotorName() {
        return addDocotorName;
    }

    public void setAddDocotorName(String addDocotorName) {
        this.addDocotorName = addDocotorName;
    }

    public String getAddSerialNumber() {
        return addSerialNumber;
    }

    public void setAddSerialNumber(String addSerialNumber) {
        this.addSerialNumber = addSerialNumber;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}

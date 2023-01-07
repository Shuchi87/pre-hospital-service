package com.example.pre_hospitalservicesandsupplies;

public class AddMedicalIn {

    String addDocotorName,addDesignation,addTime,addSerialNumber;

    public AddMedicalIn(String addDocotorName, String addDesignation, String addTime, String addSerialNumber) {
        this.addDocotorName = addDocotorName;
        this.addDesignation = addDesignation;
        this.addTime = addTime;
        this.addSerialNumber = addSerialNumber;
    }

    public String getAddDocotorName() {
        return addDocotorName;
    }

    public void setAddDocotorName(String addDocotorName) {
        this.addDocotorName = addDocotorName;
    }

    public String getAddDesignation() {
        return addDesignation;
    }

    public void setAddDesignation(String addDesignation) {
        this.addDesignation = addDesignation;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAddSerialNumber() {
        return addSerialNumber;
    }

    public void setAddSerialNumber(String addSerialNumber) {
        this.addSerialNumber = addSerialNumber;
    }
}

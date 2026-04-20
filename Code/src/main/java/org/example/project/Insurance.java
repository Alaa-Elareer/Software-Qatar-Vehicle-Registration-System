package org.example.project;

import java.util.Date;

public class Insurance {

    private String policyNumber;
    private String insuranceCompany;
    private Date expiryDate;
    private Vehicle vehicle;

    public Insurance(String policyNumber, String insuranceCompany, Date expiryDate, Vehicle vehicle) {
        this.policyNumber = policyNumber;
        this.insuranceCompany = insuranceCompany;
        this.expiryDate = expiryDate;
        this.vehicle = vehicle;
    }

    public Boolean verifyInsurance() {
        Date currentDate = new Date();
        return currentDate.before(expiryDate);
    }


    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}



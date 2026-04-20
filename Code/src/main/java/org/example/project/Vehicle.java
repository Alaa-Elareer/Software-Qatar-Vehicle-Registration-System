package org.example.project;


import java.util.ArrayList;
import java.util.List;

public class Vehicle {

    private String VIN;
    private String make;
    private String model;
    private int year;
    private Insurance insurancePolicy;
    private FitnessCertificate fitnessCertificate;
    private List<Fine> fines; // List of fines associated with the vehicle
    private Owner currentOwner;
    private Owner previousOwner;
    private Registration registration;

    // Constructor
    public Vehicle(String VIN, String make, String model, int year, Insurance insurancePolicy, Owner currentOwner) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.insurancePolicy = insurancePolicy;
        this.currentOwner = currentOwner;
        this.fines = new ArrayList<>(); // Initialize an empty list of fines
    }

    // Getter and Setter methods
    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Insurance getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(Insurance insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public FitnessCertificate getFitnessCertificate() {
        return fitnessCertificate;
    }

    public void setFitnessCertificate(FitnessCertificate fitnessCertificate) {
        this.fitnessCertificate = fitnessCertificate;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void addFine(Fine fine) {
        this.fines.add(fine);
    }

    public Owner getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(Owner currentOwner) {
        this.currentOwner = currentOwner;
    }

    public Owner getPreviousOwner() {
        return previousOwner;
    }

    public void setPreviousOwner(Owner previousOwner) {
        this.previousOwner = previousOwner;
    }
    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    /**
     * Validates ownership by comparing the provided QID with the current owner's QID.
     *
     * @param QID The QID to validate.
     * @return true if the QID matches the current owner's QID, otherwise false.
     */
    public boolean validateOwnership(String QID) {
        if (currentOwner != null) {
            return currentOwner.getQid().equals(QID);
        }
        return false;
    }

    /**
     * Assigns a new owner to the vehicle.
     * Also updates the previous owner field.
     *
     * @param newOwner The new owner to assign to the vehicle.
     */
    public void assignNewOwner(Owner newOwner) {
        if (newOwner != null) {
            this.previousOwner = this.currentOwner; // Set the current owner as the previous owner
            this.currentOwner = newOwner; // Assign the new owner
        } else {
            throw new IllegalArgumentException("New owner cannot be null.");
        }
    }


}


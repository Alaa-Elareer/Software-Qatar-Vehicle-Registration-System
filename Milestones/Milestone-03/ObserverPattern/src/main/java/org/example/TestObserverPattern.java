package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestObserverPattern {
        public static void main(String[] args) {
            VehicleRegistration vehicleRegistration = new VehicleRegistration();

            // Create observers
            TrafficPolice trafficPolice = new TrafficPolice();
            InsuranceCompany insuranceCompany = new InsuranceCompany();

            // Register observers
            vehicleRegistration.addObserver(trafficPolice);
            vehicleRegistration.addObserver(insuranceCompany);

            // Change the registration status and notify observers
            vehicleRegistration.setStatus("Registered");
            vehicleRegistration.setStatus("Unregistered");
        }
    }

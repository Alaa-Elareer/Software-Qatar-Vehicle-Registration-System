package org.example.project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class AccidentReport {

    private String reportID;
    private Date accidentDate;
    private String location;
    private Vehicle vehicleAtFault;
    private Vehicle victimVehicle;
    private String insuranceAcknowledgment;

    public AccidentReport(String location, Vehicle vehicleAtFault, Vehicle victimVehicle) {
        this.reportID = generateReportID();
        this.accidentDate = new Date(); // Set to current date and time
        this.location = location;
        this.vehicleAtFault = vehicleAtFault;
        this.victimVehicle = victimVehicle;
        this.insuranceAcknowledgment = "";
    }

    // Method to generate a unique report ID
    private String generateReportID() {
        return UUID.randomUUID().toString();
    }

    public void fileReport(Vehicle vehicleAtFault, Vehicle victimVehicle, String location) {
        this.vehicleAtFault = vehicleAtFault;
        this.victimVehicle = victimVehicle;
        this.location = location;
        this.accidentDate = new Date();
        this.reportID = generateReportID();

        System.out.println("Accident Report Filed:");
        System.out.println("Report ID: " + this.reportID);
        System.out.println("Accident Date: " + this.accidentDate);
        System.out.println("Location: " + this.location);
        System.out.println("Vehicle At Fault: " + vehicleAtFault.getModel() + " (VIN: " + vehicleAtFault.getVIN() + ")");
        System.out.println("Victim Vehicle: " + victimVehicle.getModel() + " (VIN: " + victimVehicle.getVIN() + ")");
    }

    public void sendToInsurance() {
        System.out.println("Sending accident report to insurance company...");
        this.insuranceAcknowledgment = "Acknowledged by Insurance Company on " + new Date();
        System.out.println("Insurance Acknowledgment: " + insuranceAcknowledgment);
    }

    public void receiveAcknowledgment(String acknowledgment) {
        this.insuranceAcknowledgment = acknowledgment;
    }

    public void storeReport() {
        try (FileWriter writer = new FileWriter("AccidentReports.txt", true)) {
            writer.write("Report ID: " + reportID + "\n");
            writer.write("Date: " + accidentDate + "\n");
            writer.write("Location: " + location + "\n");
            writer.write("Vehicle At Fault: " + vehicleAtFault.getVIN() + "\n");
            writer.write("Victim Vehicle: " + victimVehicle.getVIN() + "\n");
            writer.write("---------------\n");
            System.out.println("Accident report stored successfully in a file!");
        } catch (IOException e) {
            System.out.println("Error storing accident report: " + e.getMessage());
        }
    }

    public String getReportID() {
        return reportID;
    }

    public Date getAccidentDate() {
        return accidentDate;
    }

    public String getLocation() {
        return location;
    }

    public Vehicle getVehicleAtFault() {
        return vehicleAtFault;
    }

    public Vehicle getVictimVehicle() {
        return victimVehicle;
    }

    public String getInsuranceAcknowledgment() {
        return insuranceAcknowledgment;
    }
}
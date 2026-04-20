package org.example.project;

import java.util.ArrayList;
import java.util.List;

public class Owner {

    private String name;
    private String QID; // Unique identifier for the owner
    private String address;
    private String phoneNumber;
    private List<Vehicle> vehicles; // List of vehicles owned by this owner

    // Constructor
    public Owner(String name, String QID, String address, String phoneNumber) {
        this.name = name;
        this.QID = QID;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.vehicles = new ArrayList<>(); // Initialize an empty list of vehicles
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQid() {
        return QID;
    }

    public void setQid(String QID) {
        this.QID = QID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            this.vehicles.add(vehicle);
        } else {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
    }


     //Retrieves details of a specific vehicle owned by this owner.
    public String getVehicleDetails(Vehicle vehicle) {
        if (vehicles.contains(vehicle)) {
            return "Vehicle Details:\n" +
                    "VIN: " + vehicle.getVIN() + "\n" +
                    "Make: " + vehicle.getMake() + "\n" +
                    "Model: " + vehicle.getModel() + "\n" +
                    "Year: " + vehicle.getYear();
        } else {
            return "This vehicle is not owned by the specified owner.";
        }
    }

    /**
     * Updates the owner's contact information (address and phone number).
     *
     * @param newAddress New address to be updated.
     * @param newPhone   New phone number to be updated.
     */
    public void updateContactInfo(String newAddress, String newPhone) {
        if (newAddress != null && !newAddress.isEmpty()) {
            this.address = newAddress;
        }
        if (newPhone != null && !newPhone.isEmpty()) {
            this.phoneNumber = newPhone;
        }
    }
}

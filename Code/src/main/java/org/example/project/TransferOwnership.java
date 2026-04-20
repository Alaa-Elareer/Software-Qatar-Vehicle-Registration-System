package org.example.project;

import java.util.Date;

public class TransferOwnership {

    private Owner previousOwner;
    private Owner newOwner;
    private Vehicle vehicle;
    private Date transferDate;
    private String status;

    public TransferOwnership(Vehicle vehicle, Owner previousOwner, Owner newOwner) {
        this.vehicle = vehicle;
        this.previousOwner = previousOwner;
        this.newOwner = newOwner;
    }

    /**
     * Validates the conditions before transferring ownership.
     */
    public void validateOwnershipConditions() {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }

        if (previousOwner == null || newOwner == null) {
            throw new IllegalArgumentException("Both previous owner and new owner must be provided.");
        }

        //check if the vehicle has a valid registration
        Registration registration = vehicle.getRegistration();
        if (registration == null || registration.getExpiryDate().before(new Date())) {
            throw new IllegalStateException("The vehicle registration is invalid or expired.");
        }
        System.out.println("Ownership conditions validated.");
    }


     // Executes the transfer
    public Boolean executeTransfer(Vehicle vehicle, Owner previousOwner, Owner newOwner) {
        // Validate conditions before proceeding the transfer
        try {
            validateOwnershipConditions();
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
            return false;
        }

        this.transferDate = new Date();
        this.status = "Transferred";
        vehicle.setCurrentOwner(newOwner);

        System.out.println("Transfer successful! Vehicle: " + vehicle.getModel() + " is now owned by: " + newOwner.getName());
        System.out.println("Transfer Date: " + transferDate);
        return true;
    }

    // Getter and Setter methods
    public Owner getPreviousOwner() {
        return previousOwner;
    }

    public void setPreviousOwner(Owner previousOwner) {
        this.previousOwner = previousOwner;
    }

    public Owner getNewOwner() {
        return newOwner;
    }

    public void setNewOwner(Owner newOwner) {
        this.newOwner = newOwner;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public String getStatus() {
        return status;
    }
}




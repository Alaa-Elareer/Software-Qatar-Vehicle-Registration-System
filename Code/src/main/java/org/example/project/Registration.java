package org.example.project;

import java.util.Date;

public class Registration {

    private String registrationNumber;
    private Date expiryDate;

    public Registration(String registrationNumber, Date expiryDate) {
        this.registrationNumber = registrationNumber;
        this.expiryDate = expiryDate;
    }
    public Date getExpiryDate() {
        return expiryDate; // Return the expiry date of the registration
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Renews the vehicle registration by extending the expiry date.
     *
     * @param vehicle The vehicle to renew the registration for.
     */
    public void renewRegistration(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }

        // extend the registration by one year
        Date newExpiryDate = new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000);
        this.expiryDate = newExpiryDate;
        System.out.println("Registration for vehicle " + vehicle.getModel() + " renewed. New expiry date: " + expiryDate);
    }

    /**
     * Registers a new vehicle with an owner.
     *
     * @param vehicle The vehicle to register.
     * @param owner The owner of the vehicle.
     */
    public void registerVehicle(Vehicle vehicle, Owner owner) {
        if (vehicle == null || owner == null) {
            throw new IllegalArgumentException("Vehicle and owner cannot be null.");
        }

        this.registrationNumber = generateRegistrationNumber(vehicle.getModel());
        this.expiryDate = new Date(System.currentTimeMillis() + 365L * 24 * 60 * 60 * 1000);  // 1 year validity

        System.out.println("Vehicle " + vehicle.getModel() + " registered to owner " + owner.getName());
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Expiry Date: " + expiryDate);
    }

    /**
     * Updates the ownership of the vehicle to a new owner.
     *
     * @param vehicle The vehicle to update ownership for.
     * @param owner The new owner of the vehicle.
     */
    public void updateOwnerShip(Vehicle vehicle, Owner owner) {
        if (vehicle == null || owner == null) {
            throw new IllegalArgumentException("Vehicle and owner cannot be null.");
        }
        vehicle.setCurrentOwner(owner);
        System.out.println("Ownership of vehicle " + vehicle.getModel() + " updated to " + owner.getName());
    }


    public void generateRegistrationSticker() {
        if (registrationNumber == null || expiryDate == null) {
            throw new IllegalStateException("Registration details are incomplete.");
        }


        System.out.println("==== Registration Sticker ====");
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("================================");
    }
    private String generateRegistrationNumber(String model) {
        String registrationNumber = model.substring(0, 3).toUpperCase() + "-" + System.currentTimeMillis();
        return registrationNumber;
    }
}



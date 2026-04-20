package org.example.project;

import java.util.Date;
import java.util.List;

public class Fine {

    private String fineID;
    private double amount;
    private Date dueDate;
    private Boolean paidStatus;

    public Fine(String fineID, double amount, Date dueDate) {
        this.fineID = fineID;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paidStatus = false; // By default, fines are unpaid
    }

    public String getFineID() {
        return fineID;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Boolean getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(Boolean paidStatus) {
        this.paidStatus = paidStatus;
    }

    // Method to check fines associated with a vehicle
    public void checkFines(Vehicle vehicle) {
        List<Fine> fines = vehicle.getFines(); // Assuming Vehicle has a getFines() method
        if (fines.isEmpty()) {
            System.out.println("No fines for this vehicle.");
        } else {
            for (Fine fine : fines) {
                System.out.println("Fine ID: " + fine.getFineID() + ", Amount: " + fine.getAmount() + ", Due Date: " + fine.getDueDate());
            }
        }
    }

    // Method to create an invoice for a transfer fee
    public void createInvoiceForTransferFee() {
        // assume transfer fee is a fixed amount= 100
        double transferFee = 100.0;
        System.out.println("Invoice created for Transfer Fee: $" + transferFee);
    }

    // Method to get unpaid fines by VIN
    public void getUnpaidFines(int VIN, List<Fine> fines) {
        System.out.println("Unpaid fines for VIN: " + VIN);
        for (Fine fine : fines) {
            if (!fine.getPaidStatus()) {
                System.out.println("Fine ID: " + fine.getFineID() + ", Amount: " + fine.getAmount() + ", Due Date: " + fine.getDueDate());
            }
        }
    }

    // Method to compute total of all fines
    public double computeTotal(List<Fine> fines) {
        double total = 0.0;
        for (Fine fine : fines) {
            if (!fine.getPaidStatus()) {
                total += fine.getAmount();
            }
        }
        return total;
    }

    public void updateFineStatus(String fineID, boolean status, List<Fine> fines) {
        for (Fine fine : fines) {
            if (fine.getFineID().equals(fineID)) {
                fine.setPaidStatus(status);
                System.out.println("Fine status updated. Fine ID: " + fine.getFineID() + " is now " + (status ? "Paid" : "Unpaid"));
                return;
            }
        }
        System.out.println("Fine ID not found.");
    }
}


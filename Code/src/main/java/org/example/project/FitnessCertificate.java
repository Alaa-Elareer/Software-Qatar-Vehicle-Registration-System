package org.example.project;

import java.util.Date;

public class FitnessCertificate {

    private String certificateNumber;
    private Date issueDate;
    private Date expiryDate;

    public FitnessCertificate(String certificateNumber, Date issueDate, Date expiryDate) {
        this.certificateNumber = certificateNumber;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    /*
     * @param vehicle The vehicle to verify the fitness status for.
     * @return true if the fitness certificate is valid and not expired; false otherwise.
     */

    public boolean verifyFitness(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        Date currentDate = new Date();
        if (currentDate.after(expiryDate)) {
            return false; // Certificate is expired
        }
        return true;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "FitnessCertificate [certificateNumber=" + certificateNumber + ", issueDate=" + issueDate + ", expiryDate=" + expiryDate + "]";
    }
}


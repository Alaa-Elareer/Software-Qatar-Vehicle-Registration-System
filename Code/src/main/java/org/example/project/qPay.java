package org.example.project;

public class qPay {

    private String transactionID;
    private Boolean paymentStatus;
    private double amount;  // Use double for better precision

    public qPay() {
        // Default constructor
    }

    /**
     * Processes the payment for the given vehicle and amount.
     *
     * @param vehicle The vehicle object representing the transaction.
     * @param amount The amount to be paid.
     */
    public void processPayment(Vehicle vehicle, double amount) {
        if (vehicle == null || amount <= 0) {
            throw new IllegalArgumentException("Invalid vehicle or amount.");
        }
        this.transactionID = generateTransactionID();
        this.paymentStatus = true;
        this.amount = amount;
        System.out.println("Payment processed for vehicle: " + vehicle.getModel());
    }

    /**
     * Checks the validity of the given card details.
     *
     * @param cardDetails The card number or card details as a String.
     */
    public void checkValidity(String cardDetails) {
        if (cardDetails == null || cardDetails.isEmpty()) {
            throw new IllegalArgumentException("Card details cannot be empty.");
        }

        // check if the card is active
        boolean isValid = cardDetails.matches("\\d{16}");  // check for a 16-digit card number
        if (!isValid) {
            throw new IllegalArgumentException("Invalid card details.");
        }

        System.out.println("Card details validated.");
    }

    /**
     * Generates a unique transaction ID.

     */
    private String generateTransactionID() {
        return "TXN" + System.currentTimeMillis();
    }
}

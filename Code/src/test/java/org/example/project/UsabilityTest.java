package org.example.project;

import java.util.Scanner;
import java.util.Date;

public class UsabilityTest {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        testUserInteraction();

        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Usability Test Duration: " + duration + " nanoseconds.");
    }

    public static void testUserInteraction() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vehicle Registration and Accident System!");
        System.out.println("Please choose an option: ");
        System.out.println("1. Register Accident");
        System.out.println("2. Pay Fine");
        System.out.println("3. Exit");

        int userChoice = scanner.nextInt();

        if (userChoice == 1) {
            System.out.println("Accident registration in progress...");
            performAccidentRegistration();
        } else if (userChoice == 2) {
            System.out.println("Fine payment in progress...");
            payFine();
        } else {
            System.out.println("Exiting the system.");
        }

        scanner.close();
    }

    public static void performAccidentRegistration() {
        Vehicle offendingVehicle = new Vehicle("1234", "Toyota", "Camry", 2020, null, null);
        Vehicle victimVehicle = new Vehicle("5678", "Honda", "Civic", 2021, null, null);
        AccidentReport report = new AccidentReport("Location", offendingVehicle, victimVehicle);
        report.fileReport(offendingVehicle, victimVehicle, "Location");
        report.storeReport();
        System.out.println("Accident registered successfully!");
    }

    public static void payFine() {
        Vehicle vehicle = new Vehicle("1234", "Toyota", "Camry", 2020, null, null);
        Fine fine = new Fine("F1234", 200.0, new Date());
        fine.checkFines(vehicle);
        qPay payment = new qPay();
        payment.processPayment(vehicle, 200.0);
        System.out.println("Fine paid successfully!");
    }
}

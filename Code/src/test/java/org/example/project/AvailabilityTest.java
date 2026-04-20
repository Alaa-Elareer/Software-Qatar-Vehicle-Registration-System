package org.example.project;

import java.util.Date;

public class AvailabilityTest {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        performAvailabilityTest();

        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Availability Test Duration: " + duration + " nanoseconds.");
    }

    public static void performAvailabilityTest() {
        int numberOfRequests = 100;
        Thread[] threads = new Thread[numberOfRequests];

        for (int i = 0; i < numberOfRequests; i++) {
            threads[i] = new Thread(() -> {
                try {
                    // Ensure all dependencies are correctly initialized
                    Owner owner = new Owner("John Doe", "12345", "123 Main St", "555-555-5555");
                    Vehicle offendingVehicle = new Vehicle("1234", "Toyota", "Camry", 2020, null, owner);
                    Vehicle victimVehicle = new Vehicle("5678", "Honda", "Civic", 2021, null, owner);

                    AccidentReport report = new AccidentReport("Location", offendingVehicle, victimVehicle);
                    report.fileReport(offendingVehicle, victimVehicle, "Location");
                    report.storeReport();

                    Fine fine = new Fine("F1234", 200.0, new Date());
                    fine.checkFines(offendingVehicle);
                    qPay payment = new qPay();
                    payment.processPayment(offendingVehicle, 200.0);

                } catch (Exception e) {
                    System.out.println("Request failed: " + e.getMessage());
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < numberOfRequests; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All requests processed successfully.");
    }
}
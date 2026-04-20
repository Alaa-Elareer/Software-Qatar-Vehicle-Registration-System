package org.example.project;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AccidentReportTest {

    @Test
    void testFileReport() {
        // Arrange
        Vehicle vehicleAtFault = new Vehicle("1234", "Toyota", "Corolla", 2020, null, new Owner("John Doe", "12345", "123 Main St", "555-555-5555"));
        Vehicle victimVehicle = new Vehicle("5678", "Honda", "Civic", 2018, null, new Owner("Jane Smith", "67890", "456 Oak St", "555-555-6789"));

        AccidentReport report = new AccidentReport("Doha", vehicleAtFault, victimVehicle);

        // Assert
        assertNotNull(report.getReportID());
        assertEquals("Doha", report.getLocation());
        assertEquals(vehicleAtFault, report.getVehicleAtFault());
        assertEquals(victimVehicle, report.getVictimVehicle());
    }

    @Test
    void testSendToInsurance() {
        // Arrange
        Vehicle vehicleAtFault = new Vehicle("1234", "Toyota", "Corolla", 2020, null, new Owner("John Doe", "12345", "123 Main St", "555-555-5555"));
        Vehicle victimVehicle = new Vehicle("5678", "Honda", "Civic", 2018, null, new Owner("Jane Smith", "67890", "456 Oak St", "555-555-6789"));
        AccidentReport report = new AccidentReport("Doha", vehicleAtFault, victimVehicle);

        // Act
        report.sendToInsurance();

        // Assert
        assertTrue(report.getInsuranceAcknowledgment().contains("Acknowledged by Insurance Company"));
    }

    @Test
    void testStoreReport() {
        // Arrange
        Vehicle vehicleAtFault = new Vehicle("1234", "Toyota", "Corolla", 2020, null, new Owner("John Doe", "12345", "123 Main St", "555-555-5555"));
        Vehicle victimVehicle = new Vehicle("5678", "Honda", "Civic", 2018, null, new Owner("Jane Smith", "67890", "456 Oak St", "555-555-6789"));
        AccidentReport report = new AccidentReport("Doha", vehicleAtFault, victimVehicle);

        // Act
        report.storeReport();

        // Assert
        File file = new File("AccidentReports.txt");
        assertTrue(file.exists());
    }
}

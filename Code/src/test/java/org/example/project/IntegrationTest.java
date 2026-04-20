package org.example.project;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest {

    @Test
    void testManageAccidentIntegration() throws IOException {
        // Set up vehicles
        Owner owner1 = new Owner("Ahmed", "12345", "123St", "555-555-5555");
        Owner owner2 = new Owner("Nasser", "67890", "456St", "555-555-6789");
        Vehicle offendingVehicle = new Vehicle("VIN1234", "Toyota", "Corolla", 2020, null, owner1);
        Vehicle victimVehicle = new Vehicle("VIN5678", "Honda", "Civic", 2022, null, owner2);

        // Create accident report
        AccidentReport report = new AccidentReport("Downtown", offendingVehicle, victimVehicle);
        report.fileReport(offendingVehicle, victimVehicle, "Downtown");
        report.sendToInsurance();
        report.storeReport();

        // Validate the report
        assertNotNull(report.getReportID(), "Report ID should not be null");
        assertEquals("Downtown", report.getLocation(), "Location mismatch");
        assertEquals(offendingVehicle, report.getVehicleAtFault(), "Offending vehicle mismatch");
        assertEquals(victimVehicle, report.getVictimVehicle(), "Victim vehicle mismatch");

        // Check that the report is stored in a file
        File file = new File("AccidentReports.txt");
        assertTrue(file.exists(), "Accident report file should exist");

        //Clear after testing
        file.delete();
    }
}

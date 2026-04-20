package org.example.project;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Date;

public class ManageAccidentFX {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Manage Accident");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label offendingVinLabel = new Label("Offending Vehicle VIN:");
        GridPane.setConstraints(offendingVinLabel, 0, 0);
        TextField offendingVinInput = new TextField();
        GridPane.setConstraints(offendingVinInput, 1, 0);

        Label victimVinLabel = new Label("Victim Vehicle VIN:");
        GridPane.setConstraints(victimVinLabel, 0, 1);
        TextField victimVinInput = new TextField();
        GridPane.setConstraints(victimVinInput, 1, 1);

        // Accident Details
        Label locationLabel = new Label("Accident Location:");
        GridPane.setConstraints(locationLabel, 0, 2);
        TextField locationInput = new TextField();
        GridPane.setConstraints(locationInput, 1, 2);

        Label descriptionLabel = new Label("Accident Description:");
        GridPane.setConstraints(descriptionLabel, 0, 3);
        TextField descriptionInput = new TextField();
        GridPane.setConstraints(descriptionInput, 1, 3);

        // Date Picker for Accident Date
        Label dateLabel = new Label("Accident Date:");
        GridPane.setConstraints(dateLabel, 0, 4);
        DatePicker datePicker = new DatePicker();
        GridPane.setConstraints(datePicker, 1, 4);


        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 5);

        Button exitButton = new Button("Exit");
        GridPane.setConstraints(exitButton, 1, 6);
        exitButton.setOnAction(e -> window.close());

        Label outputLabel = new Label();
        GridPane.setConstraints(outputLabel, 0, 7, 2, 1);

        submitButton.setOnAction(e -> {
            try {
                // Step 1: Gather input details
                String offendingVin = offendingVinInput.getText().trim();
                String victimVin = victimVinInput.getText().trim();
                String location = locationInput.getText().trim();
                String description = descriptionInput.getText().trim();
                LocalDate accidentDate = datePicker.getValue();

                if (offendingVin.isEmpty() || victimVin.isEmpty() || location.isEmpty() || description.isEmpty()) {
                    outputLabel.setText("Error: All fields must be filled!");
                    return;
                }
                if (accidentDate == null) {
                    outputLabel.setText("Error: Accident date must be selected!");
                    return;
                }

                // Retrieve vehicle details by VIN
                Vehicle offendingVehicle = findVehicleByVIN(offendingVin);
                Vehicle victimVehicle = findVehicleByVIN(victimVin);

                if (offendingVehicle == null || victimVehicle == null) {
                    outputLabel.setText("Error: One or both vehicles could not be found!");
                    return;
                }

                // Record accident details
                AccidentReport report = new AccidentReport(location, offendingVehicle, victimVehicle);
                report.fileReport(offendingVehicle, victimVehicle, location);

                // Confirm accident details with the vehicle owner
                if (!showConfirmation("Confirm Accident Report", "Do you confirm the accident details?")) {
                    outputLabel.setText("Accident report creation was canceled.");
                    return;
                }

                // Store the accident details and report
                report.storeReport();

                // Check insurance policies
                if (offendingVehicle.getInsurancePolicy() == null) {
                    outputLabel.setText("Error: No insurance policy found for the offending vehicle.");
                    return;
                }

                // Send the report to the insurance company
                report.sendToInsurance();
                report.receiveAcknowledgment("Acknowledged by Insurance Company on " + new Date());

                // Save acknowledgment and final report
                report.storeReport();
                outputLabel.setText("Success: Accident report filed and sent to insurance.");
            } catch (Exception ex) {
                outputLabel.setText("Error: " + ex.getMessage());
            }
        });

        grid.getChildren().addAll(
                offendingVinLabel, offendingVinInput,
                victimVinLabel, victimVinInput,
                locationLabel, locationInput,
                descriptionLabel, descriptionInput,
                dateLabel, datePicker,
                submitButton, exitButton,
                outputLabel
        );

        Scene scene = new Scene(grid, 400, 400);
        window.setScene(scene);
        window.show();
    }

    /**
     * Simulate finding a Vehicle by its VIN.
     */
    private static Vehicle findVehicleByVIN(String vin) {
        // Simulate vehicle retrieval (replace with actual database or API call)
        Owner owner = new Owner("Owner Name", "QID123", "Owner Address", "555-1234");
        Insurance insurance = new Insurance("POLICY123", "Qatar Insurance", new Date(System.currentTimeMillis() + 365L * 24 * 60 * 60 * 1000), null);
        return new Vehicle(vin, "Toyota", "Corolla", 2020, insurance, owner);
    }

    /**
     * Utility method to show a confirmation dialog.
     */
    private static boolean showConfirmation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        return alert.showAndWait().isPresent();
    }
}

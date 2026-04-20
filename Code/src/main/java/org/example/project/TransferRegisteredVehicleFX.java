package org.example.project;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Date;

public class TransferRegisteredVehicleFX {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Transfer Registered Vehicle");

        // Create layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label vinLabel = new Label("Vehicle Identification Number (VIN):");
        GridPane.setConstraints(vinLabel, 0, 0);
        TextField vinInput = new TextField();
        GridPane.setConstraints(vinInput, 1, 0);

        Label qidLabel = new Label("Current Owner QID:");
        GridPane.setConstraints(qidLabel, 0, 1);
        TextField qidInput = new TextField();
        GridPane.setConstraints(qidInput, 1, 1);

        // New Owner Name Input
        Label newNameLabel = new Label("New Owner Name:");
        GridPane.setConstraints(newNameLabel, 0, 2);
        TextField newNameInput = new TextField();
        GridPane.setConstraints(newNameInput, 1, 2);

        // New Owner QID Input
        Label newQidLabel = new Label("New Owner QID:");
        GridPane.setConstraints(newQidLabel, 0, 3);
        TextField newQidInput = new TextField();
        GridPane.setConstraints(newQidInput, 1, 3);


        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 4);
        Button exitButton = new Button("Exit");
        GridPane.setConstraints(exitButton, 1, 5);


        Label outputLabel = new Label();
        GridPane.setConstraints(outputLabel, 0, 6, 2, 1);

        submitButton.setOnAction(e -> {
            String vin = vinInput.getText();
            String currentOwnerQid = qidInput.getText();
            String newOwnerName = newNameInput.getText();
            String newOwnerQid = newQidInput.getText();

            if (!retrieveRegistrationDetails(vin, currentOwnerQid)) {
                outputLabel.setText("Error: Incorrect Information.");
            } else if (checkUnpaidBills(vin)) {
                outputLabel.setText("Error: Pay the bills first.");
            } else {
                String result = processTransfer(vin, currentOwnerQid, newOwnerName, newOwnerQid);
                outputLabel.setText(result);
            }
        });


        exitButton.setOnAction(e -> window.close());

        grid.getChildren().addAll(
                vinLabel, vinInput,
                qidLabel, qidInput,
                newNameLabel, newNameInput,
                newQidLabel, newQidInput,
                submitButton, exitButton,
                outputLabel
        );

        // Set the scene
        Scene scene = new Scene(grid, 400, 300);
        window.setScene(scene);
        window.show();
    }

    private static boolean retrieveRegistrationDetails(String vin, String qid) {
        Vehicle vehicle = findVehicleByVIN(vin);
        if (vehicle == null) {
            return false; // Vehicle not found
        }
        return vehicle.getCurrentOwner() != null && vehicle.getCurrentOwner().getQid().equals(qid);
    }

    private static boolean checkUnpaidBills(String vin) {
        Vehicle vehicle = findVehicleByVIN(vin);
        return vehicle != null && !vehicle.getFines().isEmpty();
    }

    private static String processTransfer(String vin, String currentOwnerQid, String newOwnerName, String newOwnerQid) {
        Vehicle vehicle = findVehicleByVIN(vin);
        Owner previousOwner = vehicle.getCurrentOwner();
        Owner newOwner = new Owner(newOwnerName, newOwnerQid, "456St", "555-555-1234");

        TransferOwnership transfer = new TransferOwnership(vehicle, previousOwner, newOwner);
        boolean success = transfer.executeTransfer(vehicle, previousOwner, newOwner);

        if (success) {
            String invoice = createInvoice(vehicle, newOwner);
            String registrationSticker = createRegistrationSticker(vehicle);
            return String.format("Ownership transfer successful for VIN: %s to new owner: %s (QID: %s)\nInvoice: %s\nRegistration Sticker: %s",
                    vin, newOwnerName, newOwnerQid, invoice, registrationSticker);
        } else {
            return "Ownership transfer failed.";
        }
    }

    private static Vehicle findVehicleByVIN(String vin) {
        Owner owner = new Owner("John Doe", "56789", "123 Main St", "555-555-5555");
        Insurance insurance = new Insurance("POLICY123", "Qatar Insurance", new Date(System.currentTimeMillis() + 365L * 24 * 60 * 60 * 1000), null);
        return new Vehicle(vin, "Toyota", "Corolla", 2020, insurance, owner);
    }

    private static String createInvoice(Vehicle vehicle, Owner newOwner) {
        return String.format("Invoice for %s (%s): $200", vehicle.getModel(), newOwner.getName());
    }

    private static String createRegistrationSticker(Vehicle vehicle) {
        return String.format("Sticker for %s (%s)", vehicle.getModel(), vehicle.getVIN());
    }
}

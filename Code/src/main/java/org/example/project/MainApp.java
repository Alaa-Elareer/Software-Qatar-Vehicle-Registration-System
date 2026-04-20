package org.example.project;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("QVR System - Main Menu");

        Button transferVehicleButton = new Button("Transfer Registered Vehicle");
        Button manageAccidentButton = new Button("Manage Accident");
        Button exitButton = new Button("Exit");

        transferVehicleButton.setOnAction(e -> TransferRegisteredVehicleFX.display());
        manageAccidentButton.setOnAction(e -> ManageAccidentFX.display());
        exitButton.setOnAction(e -> Platform.exit());

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(transferVehicleButton, manageAccidentButton, exitButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}

package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestFactoryPattern {
        public static void main(String[] args) {
            VehicleFactory factory = new VehicleFactory();

            Vehicle vehicle1 = factory.createVehicle("Car");
            vehicle1.displayType();  // Output: This is a Car.

            Vehicle vehicle2 = factory.createVehicle("Truck");
            vehicle2.displayType();  // Output: This is a Truck.
        }
    }

package org.example;

public class TrafficPolice implements Observer {
    @Override
    public void update(String status) {
        System.out.println("Traffic Police notified of status change: " + status);
    }
}

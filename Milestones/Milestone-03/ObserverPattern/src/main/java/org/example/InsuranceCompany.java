package org.example;

public class InsuranceCompany implements Observer {
    @Override
    public void update(String status) {
        System.out.println("Insurance Company notified of status change: " + status);
    }
}

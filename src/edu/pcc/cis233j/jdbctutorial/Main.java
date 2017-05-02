package edu.pcc.cis233j.jdbctutorial;

import static java.lang.System.*;
import java.util.ArrayList;



public class Main {

    public static void main(String[] args) {
        System.out.println("FiredUp Customers:");
        FiredUpDB firedUp = new FiredUpDB();
        ArrayList<Customer> customers = firedUp.readCustomers();
        for (Customer cust : customers) {
            System.out.println("ID: " + cust.getId() +
                    ", Name: " + cust.getName() +
                    ", City: " + cust.getCity() +
                    ", State: " + cust.getState());
        }
    }
}

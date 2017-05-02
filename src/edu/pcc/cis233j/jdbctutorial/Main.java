package edu.pcc.cis233j.jdbctutorial;

import static java.lang.System.*;
import java.util.ArrayList;



public class Main {

    public static void main(String[] args) {
        System.out.println("FiredUp Customers:");
        FiredUpDB firedUp = new FiredUpDB();
        ArrayList<Customer> customers = firedUp.readCustomers();
        for (Customer cust : customers) {

            System.out.println("ID: " + cust.getId() + //print customer info
                    ", Name: " + cust.getName() +
                    ", City: " + cust.getCity() +
                    ", State: " + cust.getState());

            ArrayList<String> emailAddys = cust.getEmailAddress(); //get addresses
            for (String addy : emailAddys) { // print all addresses
                System.out.println("(" + addy + ")");
            }
        }
    }
}

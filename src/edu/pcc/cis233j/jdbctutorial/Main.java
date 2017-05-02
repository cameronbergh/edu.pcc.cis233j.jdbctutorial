package edu.pcc.cis233j.jdbctutorial;

import static java.lang.System.*;



public class Main {

    public static void main(String[] args) {
        System.out.println("FiredUp Customers:");
        FiredupDB firedUp = new FiredupDB();
        firedUp.readCustomers();
    }
}

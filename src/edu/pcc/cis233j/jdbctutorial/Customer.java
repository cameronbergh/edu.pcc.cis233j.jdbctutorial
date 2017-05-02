package edu.pcc.cis233j.jdbctutorial;

import java.util.ArrayList;

/**
 * Created by SYTC311u27 on 5/1/2017.
 */
public class Customer {

    private int id;
    private String name;
    private String city;
    private String state;
    private ArrayList emailAddresses = new ArrayList<String>();

    public Customer(int id, String name, String city, String state) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public void addEmailAddress(String addy){
        emailAddresses.add(addy);
    }

    public ArrayList<String> getEmailAddress(){
        return emailAddresses;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }
}

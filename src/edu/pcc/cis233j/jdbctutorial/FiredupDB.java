package edu.pcc.cis233j.jdbctutorial;
import java.sql.*;


/**
 * Created by SYTC311u27 on 5/1/2017.
 */
public class FiredupDB {

    private static final String FIREDUP_URL = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/FiredUp";
    private static final String USERNAME = "275student";
    private static final String PASSWORD = "275student";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(FIREDUP_URL, USERNAME, PASSWORD);
    }

    public void readCustomers() {
        try (
                Connection conn = getConnection();
                // additional resources will go here
        ) {
            System.out.println("Read customers...");
            // code utilizing resources will go here
        } catch (SQLException e) {
            e.printStackTrace();
        }
}}

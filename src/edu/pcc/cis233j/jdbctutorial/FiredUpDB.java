package edu.pcc.cis233j.jdbctutorial;
import java.sql.*;
import java.util.ArrayList;


/**
 * Created by SYTC311u27 on 5/1/2017.
 */
public class FiredUpDB {

    private static final String FIREDUP_URL = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/FiredUp";
    private static final String USERNAME = "275student";
    private static final String PASSWORD = "275student";


    private static final String CUSTOMER_SQL = "SELECT CustomerID, Name, City, StateProvince FROM CUSTOMER";


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(FIREDUP_URL, USERNAME, PASSWORD);
    }

    public ArrayList<Customer> readCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(CUSTOMER_SQL);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("CustomerID"),
                        rs.getString("Name"),
                        rs.getString("City"),
                        rs.getString("StateProvince")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}

package edu.pcc.cis233j.jdbctutorial;
import java.sql.*;
import java.util.ArrayList;


/**
 * Created by SYTC311u27 on 5/1/2017.
 */
public class FiredUpDB {

    private static final String FIREDUP_URL = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";


    private static final String CUSTOMER_SQL = "SELECT CustomerID, Name, City, StateProvince FROM CUSTOMER";
    private static final String EMAIL_SQL = "SELECT EmailAddress FROM EMAIL WHERE FK_CustomerID = ?";


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(FIREDUP_URL, USERNAME, PASSWORD);
    }

    public ArrayList<Customer> readCustomers() {
        ArrayList<Customer> customers = readCustomerBasics();
        readEmailAddresses(customers);
        return customers;
    }

    private void readEmailAddresses(ArrayList<Customer> customers) {
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(EMAIL_SQL)
        ) {
            for (Customer cust : customers) {
                stmt.setInt(1, cust.getId());
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    cust.addEmailAddress(rs.getString("EmailAddress"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> readCustomerBasics() {
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

package com.service;

import com.model.Product;

import java.sql.*;

public class ProductDAO {
    private static Connection getConnection() {
        Connection con = null;
        try {
            System.out.println("Loading driver");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/project_two", "root", "Oitnommc3.");
            System.out.println("Connection is" + (con == null ? "null" : "not null"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public Product getProductByProductID(int productID) {
        Product retVal = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from products where id=?");
            ps.setInt(1, productID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                retVal = new Product(rs.getInt(1), rs.getString(2));
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return retVal;
    }
}

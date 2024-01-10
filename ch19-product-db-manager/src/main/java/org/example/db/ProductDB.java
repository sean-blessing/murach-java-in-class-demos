package org.example.db;

import org.example.model.Product;
import java.sql.*;
import java.util.ArrayList;

public class ProductDB {

    public static Connection getConnection() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/murach";
        String username = "murach_user"; String password = "sesame";
        Connection connection = DriverManager.getConnection( dbURL, username, password); return connection;
    }

    public static ArrayList<Product> getAll() {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            // iterate through result set to populate list of products
            while (rs.next()) {
                String code = rs.getString("ProductCode");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");

                Product p = new Product(code, description, price);
                products.add(p);
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        return products;
    }

    public static Product get(String code) {
        Product product = null;
        String sql = "SELECT * FROM products WHERE ProductCode = ?";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");

                product = new Product(code, description, price);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        return product;
    }

}

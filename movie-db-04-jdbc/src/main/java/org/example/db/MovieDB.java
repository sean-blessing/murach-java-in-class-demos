package org.example.db;

import org.example.model.Movie;
import java.sql.*;
import java.util.ArrayList;

public class MovieDB {

    public static Connection getConnection() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/bmdb";
        String username = "bmdb_user"; String password = "sesame";
        Connection connection = DriverManager.getConnection( dbURL, username, password); return connection;
    }

    public static ArrayList<Movie> getAll() {
        ArrayList<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            // iterate through result set to populate list of movies
            while (rs.next()) {
                Movie m = getMovieFromResultSet(rs);
                movies.add(m);
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        return movies;
    }

    public static Movie get(int id) {
        Movie movie = null;
        String sql = "SELECT * FROM movie WHERE ID = ?";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                movie = getMovieFromResultSet(rs);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        return movie;
    }

    public static boolean add(Movie m) {
        String sql = "INSERT INTO Movie (Title, Year, Rating, Director) "+
                     "VALUES (?, ?, ?, ?)";
        boolean success = false;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, m.getTitle());
            ps.setInt(2, m.getYear());
            ps.setString(3, m.getRating());
            ps.setString(4, m.getDirector());
            ps.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.err.println("Add failed for movie: "+m);
            System.err.println(e);
        }

        return success;
    }

    public static boolean delete(Movie m) {
        boolean success = false;

        String sql = "DELETE FROM Movie" +
                     " WHERE ID = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, m.getId());
            ps.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.err.println("Delete failed for movie: "+m);
            System.err.println(e);
        }
        return success;
    }

    private static Movie getMovieFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("ID");
        String title = rs.getString("Title");
        int year = rs.getInt("Year");
        String rating = rs.getString("Rating");
        String director = rs.getString("Director");
        Movie m = new Movie(id, title, year, rating, director);
        return m;
    }

}

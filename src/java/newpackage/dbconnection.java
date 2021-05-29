package newpackage;

import java.sql.*;

public class dbconnection {

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/signin", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error" + ex.getMessage());
            return null;
        }
    }

    private static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Database.close() Error " + ex.getMessage());
        }
    }

    public static boolean Validate(String username, String password) {
        Connection con = null;

        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM login WHERE username='" + username + "' AND password='" + password + "'");

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error " + ex.getMessage());
            return false;
        } finally {
            close(con);
        }
        return false;
    }
}

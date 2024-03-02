package exe.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbms {
    private static Connection con = null;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String url = "jdbc:mysql://localhost:3306/airline";
            final String user = "root";
            final String password = "";
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            // e.printStackTrace();
            throw new SQLException("DB Connection failed.");
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

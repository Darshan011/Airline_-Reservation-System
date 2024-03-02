package exe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import exe.view.passenger;

public class passengermodel {
    static dbms dbms = new dbms();

    static Connection con;

    static {
        try {
            con = dbms.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static ArrayList passengerdetail(String mail) {
        try {
            String sql = "SELECT * FROM login where ROLE=? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "passenger");
            ResultSet rt = stmt.executeQuery();
            ResultSetMetaData meta = (ResultSetMetaData) rt.getMetaData();
            int col = meta.getColumnCount();
            ArrayList<Object> result = new ArrayList<>();
            while (rt.next()) {
                ArrayList<Object> row = new ArrayList<>();
                for (int i = 1; i <= col; i++) {
                    Object data = rt.getObject(i);
                    row.add(data);
                }
                result.add(row);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static boolean toremovepassenger(String name, String p_mail) {
        try {
            String sql = "UPDATE login SET ISDEL='1' WHERE P_NAME=? and MAIL_ID=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, p_mail);
            int rt = stmt.executeUpdate();
            if (rt > 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // public static ArrayList managerdetail(String mail) {
    // try {
    // String sql = "SELECT * FROM passenger where role=? ";
    // PreparedStatement stmt = con.prepareStatement(sql);
    // stmt.setString(1, "");
    // ResultSet rt = stmt.executeQuery();
    // ResultSetMetaData meta = (ResultSetMetaData) rt.getMetaData();
    // int col = meta.getColumnCount();
    // ArrayList<Object> result = new ArrayList<>();
    // while (rt.next()) {
    // ArrayList<Object> row = new ArrayList<>();
    // for (int i = 1; i <= col; i++) {
    // Object data = rt.getObject(i);
    // row.add(data);
    // }
    // result.add(row);
    // }
    // return result;
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    // return null;

    // }
}

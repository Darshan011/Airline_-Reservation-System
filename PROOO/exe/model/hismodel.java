package exe.model;

import java.sql.*;
import java.util.ArrayList;

public class hismodel {
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

    public static boolean histroy(String mail, String name, String seat, String fname) {
        try {
            String sql = "INSERT INTO his (P_Name,MAIL_ID,F_NAME,SEAT,DATE) VALUES(?,?,?,?,CURRENT_TIMESTAMP)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, mail);
            stmt.setString(3, fname);
            stmt.setString(4, seat);
            int rt = stmt.executeUpdate();
            if (rt > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static ArrayList singlepassdetail(String mail, String name) {
        try {
            String sql = "SELECT * FROM his where MAIL_ID=? and ISDEL='0' ";
            PreparedStatement stmt = con.prepareStatement(sql);
            // stmt.setString(1, f_id);
            stmt.setString(1, mail);
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

    public static ArrayList View() {
        try {
            String sql = "SELECT * FROM his where ISDEL='0' ";
            PreparedStatement stmt = con.prepareStatement(sql);
            // stmt.setString(1, f_id);
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

    public static boolean cancellhis(String mail, String fname, String id) {
        try {
            String seat = GetSeat(id);
            String sql = "update his set ISDEL='1' WHERE MAIL_ID=? AND F_NAME=? AND SEAT=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, mail);
            stmt.setString(2, fname);
            stmt.setString(3, seat);
            int rt = stmt.executeUpdate();
            if (rt > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String GetSeat(String id) {
        try {
            String sql = "SELECT SEAT FROM his WHERE ID=" + id;
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rt = pt.executeQuery();
            if (rt.next()) {
                String seat = rt.getString("SEAT");
                return seat;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

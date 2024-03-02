package exe.model;

import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class flight_detail {

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

    public static ArrayList flightdetail(String mail) {
        try {
            String sql = "SELECT * FROM flight_detail WHERE ISDEL LIKE '0'";
            PreparedStatement stmt = con.prepareStatement(sql);
            // stmt.setString(1, mail);
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

    public static ArrayList singledetail(String man_id) {
        try {
            String sql = "SELECT * FROM flight_detail where MAN_ID=? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            // stmt.setString(1, f_id);
            stmt.setString(1, man_id);
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

    public static boolean addingflight(String f_name, String totseat, String man_id) {
        try {
            String sql = "insert into passenage (F_NAME,MAN_ID,TOTAL_SEAT) values(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, f_name);
            stmt.setString(2, man_id);
            stmt.setString(3, totseat);

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

    public static boolean toremoveflight(String f_name, String man_id) {
        try {
            String sql = "UPDATE flight_detail SET ISDEL='1' WHERE F_NAME=? AND MAN_ID=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, f_name);
            stmt.setString(2, man_id);
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

    public static boolean editseat(String f_name, String seat, String mail) {
        try {
            String sql = "update flight_detail set TOTAL_SEAT= ? where F_NAME= ? and MAN_ID=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(2, f_name);
            stmt.setString(1, seat);
            stmt.setString(3, mail);

            int rt = stmt.executeUpdate();
            if (rt > 0) {
                String sq = "update flight_travel set AVA_SEAT= ? where F_NAME= ?";
                PreparedStatement stm = con.prepareStatement(sq);
                stm.setString(2, f_name);
                stm.setString(1, seat);
                int rk = stm.executeUpdate();
                if (rk > 0)
                    return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    public static boolean editf_name(String f_name, String new_fname, String man_id) {
        try {
            String sql = "update flight_detail set F_NAME= ? where F_NAME= ? and MAN_ID= ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, new_fname);
            stmt.setString(2, f_name);
            stmt.setString(3, man_id);

            int rt = stmt.executeUpdate();
            if (rt > 0) {
                String sq = "update flight_travel set F_NAME= ? where F_NAME= ? ";
                PreparedStatement stm = con.prepareStatement(sq);
                stm.setString(1, new_fname);
                stm.setString(2, f_name);
                int rk = stm.executeUpdate();
                if (rk > 0)
                    return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    public static String getF_id(String mail, String f_name) {
        try {
            String sql = "SELECT F_ID FROM flight_detail WHERE MAN_ID=? and F_NAME=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, mail);
            stmt.setString(2, f_name);
            ResultSet rt = stmt.executeQuery();
            if (rt.next()) {
                String f_id = rt.getString("F_ID");

                return f_id;
            } else {
                return "false";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

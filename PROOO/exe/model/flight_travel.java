package exe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import exe.view.menu;

public class flight_travel {
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

    public static ArrayList flighttravel(String mail) {
        try {
            String sql = "SELECT * FROM flight_travel  where DATETIME  >=CURRENT_TIMESTAMP";
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

    // public static boolean edittime(String mail, String date, String f_name) {

    // }

    public static boolean changeprice(String f_name, String price, String mail) {
        try {
            String sql = "update flight_travel set PRICE = ? where F_NAME in (select F_NAME from flight_detail where F_NAME= ? and MAN_ID=?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, price);
            stmt.setString(2, f_name);
            stmt.setString(3, mail);

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

    // error ---------------------------------------------------------
    public static boolean bookingticket(String mail, String from, String end, int noseat) {
        try {
            String sql = "update flight_travel set AVA_SEAT= AVA_SEAT-? where F_NAME= ? and MAN_ID=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, noseat);
            stmt.setString(2, from);
            stmt.setString(3, end);

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

    public static ArrayList displayticket(String mail, String date) {
        try {
            String sql = "SELECT * FROM flight_travel WHERE DATE=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, date);
            ResultSet rt = stmt.executeQuery();
            ResultSetMetaData meta = (ResultSetMetaData) rt.getMetaData();
            int col = meta.getColumnCount();
            ArrayList<Object> result = new ArrayList<>();
            while (rt.next()) {
                ArrayList<Object> row = new ArrayList<>();
                for (int i = 2; i < col; i++) {
                    if (i != 6 && i != 7) {
                        Object data = rt.getObject(i);
                        row.add(data);
                    }
                }
                result.add(row);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static boolean change(String fname, String date, String seat) {
        try {
            String sql = "SELECT AVA_SEAT,FILLED_SEAT from flight_travel WHERE DATE=? AND F_NAME=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, date);
            stmt.setString(2, fname);
            ResultSet rt = stmt.executeQuery();
            if (rt.next()) {
                int avi = rt.getInt("AVA_SEAT");
                int fill = rt.getInt("FILLED_SEAT");
                String sq = "UPDATE flight_travel SET AVA_SEAT=?,FILLED_SEAT=? WHERE DATE=? AND F_NAME=?";
                PreparedStatement pt = con.prepareStatement(sq);
                pt.setInt(1, avi - Integer.valueOf(seat));
                pt.setInt(2, fill + Integer.valueOf(seat));
                pt.setString(3, date);
                pt.setString(4, fname);
                int rk = pt.executeUpdate();
                if (rk > 0)
                    return true;
                else
                    return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean Cancell(String fname, String date, String id) {
        try {
            String seat = hismodel.GetSeat(id);
            String sq = "SELECT AVA_SEAT,FILLED_SEAT from flight_travel WHERE DATE=? AND F_NAME=?";
            PreparedStatement pt = con.prepareStatement(sq);
            pt.setString(1, date);
            pt.setString(2, fname);
            ResultSet rk = pt.executeQuery();
            if (rk.next()) {
                int avi = rk.getInt("AVA_SEAT");
                int fill = rk.getInt("FILLED_SEAT");
                String ss = "UPDATE flight_travel SET AVA_SEAT=?,FILLED_SEAT=? WHERE DATE=? AND F_NAME=?";
                PreparedStatement pk = con.prepareStatement(ss);
                pk.setInt(1, avi + Integer.valueOf(seat));
                pk.setInt(2, fill - Integer.valueOf(seat));
                pk.setString(3, date);
                pk.setString(4, fname);
                int rr = pk.executeUpdate();
                if (rr > 0)
                    return true;
                else
                    return false;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

package exe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class passdet {
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

    public static int addpassdet(String mail, String name, int age, int passbook) {
        try {
            String sq = "SELECT MAX(ORDER_ID),ORDER_ID from his WHERE MAIL_ID='" + mail + "' ";
            PreparedStatement stm = con.prepareStatement(sq);
            // stm.setString(1, mail);
            // stmt.setString(2, fname);
            ResultSet rt = stm.executeQuery();
            int rk = 0;
            if (rt.next()) {
                rk = rt.getInt("MAX(ORDER_ID)");

            }
            String sql = "insert into passdet (ORDER_ID,P_NAME,AGE,PASSBOOK) values(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, rk);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setInt(4, passbook);

            int rl = stmt.executeUpdate();
            if (rl > 0) {
                return rk;
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static ArrayList dispassdet(String mail, int orderid) {
        try {
            String sql = "SELECT * FROM passdet WHERE ORDER_ID=" + orderid;
            PreparedStatement stmt = con.prepareStatement(sql);
            // stmt.setInt(1, orderid);
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
}

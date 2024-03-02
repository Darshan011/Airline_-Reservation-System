package exe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class managermodel {
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

    public static ArrayList displaymanager(String mail) {
        try {
            String sql = "SELECT * FROM manager WHERE ISDEL LIKE '0'";
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

    public static ArrayList singledisplayman_detail(String manmail) {
        try {
            String sql = "SELECT * FROM flight_detail where MAN_MAIL=? and ISDEL LIKE '0' ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, manmail);
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

    public static boolean addingmanager(String m_name, String man_mail, String f_name, String pass) {
        try {
            String sql = "insert into manager (MAN_NAME,M_MAIL,PASS,F_NAME)values(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, m_name);
            stmt.setString(2, man_mail);
            stmt.setString(3, pass);
            stmt.setString(4, f_name);

            String sql1 = "insert into login (P_NAME,MAIL_ID,PASSWORD,ROLE) values(?,?,?,?)";
            PreparedStatement stmt1 = con.prepareStatement(sql1);
            stmt1.setString(1, m_name);
            stmt1.setString(2, man_mail);
            stmt1.setString(3, pass);
            stmt1.setString(4, "manager");

            int rt = stmt.executeUpdate();
            int rt1 = stmt1.executeUpdate();
            if (rt > 0 && rt1 > 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static ArrayList singlemanagerdetail(String mail) {
        try {
            String sql = "SELECT * FROM manager where M_MAIL=?  AND ISDEL LIKE'0' ";
            PreparedStatement stmt = con.prepareStatement(sql);
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

    public static boolean toremovemanager(String f_name, String man_id) {
        try {
            String sql = "UPDATE login SET ISDEL=? WHERE MAIL_ID=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "1");
            stmt.setString(2, man_id);
            int rt = stmt.executeUpdate();
            if (rt > 0) {
                System.out.println("true");
                String sql1 = "UPDATE manager SET ISDEL=? WHERE  M_MAIL=? and F_NAME =?";
                PreparedStatement stmt1 = con.prepareStatement(sql1);
                stmt1.setString(1, "1");
                stmt1.setString(2, man_id);
                stmt1.setString(3, f_name);
                int rt1 = stmt1.executeUpdate();
                if (rt > 0 && rt1 > 0) {
                    return true;
                }
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}

package exe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class signsetup {
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

    public static String signin(String mail, String pass) {
        try {
            String sql = "SELECT * FROM login WHERE MAIL_ID=? and ISDEL='0'  ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, mail);
            ResultSet rt = stmt.executeQuery();
            if (rt.next()) {
                String pid = rt.getString("P_ID");
                String name = rt.getString("P_NAME");
                // String gmail = rt.getString("Mail_id");
                String pas = rt.getString("PASSWORD");
                String role = rt.getString("ROLE");
                // String respid = pid;
                String ret = name + "," + role + "," + pid;
                if (pas.equals(pass)) {
                    return ret;
                } else
                    return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String signup(String name, String mail, String pass) {
        try {
            // String sql = "insert into login (P_NAME,MAIL_ID,PASSWORD) values(?,?,?)";
            // PreparedStatement stmt = con.prepareStatement(sql);
            // stmt.setString(1, name);
            // stmt.setString(2, mail);
            // stmt.setString(3, pass);
            // int rk=stmt.executeUpdate();
            // if()
            String sql = "SELECT MAIL_ID FROM login WHERE MAIL_ID='" + mail + "'";
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rk = pt.executeQuery();
            if (rk.next()) {
                return "Mail Alreday Exitst";
            } else {
                String sq = "insert into login (P_NAME,MAIL_ID,PASSWORD) values(?,?,?)";
                PreparedStatement stm = con.prepareStatement(sq);
                stm.setString(1, name);
                stm.setString(2, mail);
                stm.setString(3, pass);

                int rt = stm.executeUpdate();
                if (rt > 0) {
                    return "Added Succesfully";
                }
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}

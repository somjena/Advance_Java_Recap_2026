package EmpServices;

import Emprepo.Emprepository;
import entity.User;
import util.DButil;

import java.io.InputStream;
import java.sql.*;

public class EmpServices implements Emprepository {
    User user = new User();

    private String sql = "insert into emp values (?,?,?,?,?,?,?,?,?)";


    @Override
    public boolean register(String id, String name, double salary, String address, int age, String email, String gender, String password , InputStream imageStream) {
        Connection con = DButil.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, id);
            pr.setString(2, name);
            pr.setDouble(3, salary);
            pr.setString(4, address);
            pr.setInt(5, age);
            pr.setString(6, email);
            pr.setString(7, gender);
            pr.setString(8, password);
            pr.setBlob(9,imageStream);

            int rows = pr.executeUpdate();
            if (rows > 0) {
                return true;

            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public int getUniqueid() {
        String sql = "SELECT empid FROM emp ORDER BY empid DESC LIMIT 1";
        int id = 0;

        try (Connection con = DButil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                String empid = rs.getString(1); // EMP20
                id = Integer.parseInt(empid.replaceAll("\\D", ""));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id + 1; // returns 21
    }

    @Override
    public User verifyCredentials(String Empid, String password) {

        try {
            PreparedStatement pr = DButil.getConnection().prepareStatement("select * from emp where empid = ?");
            pr.setString(1, Empid);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user.setId(rs.getString("empid"));
                user.setPassword(rs.getString("emppassword"));
                user.setEmail(rs.getString("empemail"));
                user.setFullname(rs.getString("empname"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}








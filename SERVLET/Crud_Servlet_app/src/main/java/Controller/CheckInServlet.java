package Controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/checkin")
public class CheckInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        String empid = req.getSession().getAttribute("empid").toString();

        try (Connection con = DButil.getConnection()) {

            String sql =
                    "INSERT INTO attendance (emp_id, work_date, check_in, worked_seconds) " +
                            "VALUES (?, CURDATE(), NOW(), 0) " +
                            "ON DUPLICATE KEY UPDATE check_in = NOW()";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, empid);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


package Controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.DButil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String empid = req.getSession().getAttribute("empid").toString();

        try (Connection con = DButil.getConnection()) {

            String sql =
                    "UPDATE attendance SET " +
                            "worked_seconds = worked_seconds + " +
                            "TIMESTAMPDIFF(SECOND, check_in, NOW()), " +
                            "check_out = NOW() " +
                            "WHERE emp_id=? AND work_date=CURDATE()";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, empid);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

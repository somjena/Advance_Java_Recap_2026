package Controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DButil;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/profileImage")
public class ProfileImageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String empId = req.getParameter("id");

        try (Connection con = DButil.getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement("SELECT profile_image FROM emp WHERE empid=?");

            ps.setString(1, empId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob(1);
                byte[] image = blob.getBytes(1, (int) blob.length());

                resp.setContentType("image/jpeg");
                resp.getOutputStream().write(image);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

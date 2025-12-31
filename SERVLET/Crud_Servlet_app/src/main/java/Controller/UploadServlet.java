package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import util.DButil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/uploadImage")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 5MB
public class UploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        Part imagePart = req.getPart("image");

        try (Connection con = DButil.getConnection()) {

            String sql = "INSERT INTO users(name, image) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setBlob(2, imagePart.getInputStream());

            ps.executeUpdate();
            res.sendRedirect("view.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package Controller;

import EmpServices.EmpServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import util.EmailUtil;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/signup")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 5MB
public class SignupServlet extends HttpServlet {

    private String Domain = "EMPBBS";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        Double salary = Double.parseDouble(req.getParameter("salary"));
        String password = req.getParameter("password");

        // 🔥 IMAGE PART
        Part imagePart = req.getPart("profileImage");
        InputStream imageStream = imagePart.getInputStream();

        EmpServices es = new EmpServices();
        String id = Domain + es.getUniqueid();

        boolean success = es.register(
                id,
                fullname,
                salary,
                address,
                age,
                email,
                gender,
                password,
                imageStream
        );
        String message =
                "<!DOCTYPE html>" +
                        "<html lang='en'>" +
                        "<head>" +
                        "  <meta charset='UTF-8'>" +
                        "  <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                        "  <title>Welcome to EMS</title>" +
                        "</head>" +

                        "<body style='margin:0; padding:0; background:#f0fdf4; font-family:Arial, Helvetica, sans-serif;'>" +

                        "<table width='100%' cellpadding='0' cellspacing='0'>" +
                        "  <tr>" +
                        "    <td align='center' style='padding:30px 10px;'>" +

                        "      <table width='100%' cellpadding='0' cellspacing='0' style='max-width:600px; background:#ffffff; border-radius:14px; box-shadow:0 10px 30px rgba(0,0,0,.15); overflow:hidden;'>" +

                        "        <!-- HEADER -->" +
                        "        <tr>" +
                        "          <td style='background:linear-gradient(135deg,#16a34a,#4ade80); padding:25px; text-align:center;'>" +
                        "            <h1 style='margin:0; color:#022c22; font-size:26px;'>Employee Management System</h1>" +
                        "            <p style='margin:5px 0 0; color:#064e3b; font-size:14px;'>Welcome to EMS Portal</p>" +
                        "          </td>" +
                        "        </tr>" +

                        "        <!-- CONTENT -->" +
                        "        <tr>" +
                        "          <td style='padding:30px; color:#374151;'>" +

                        "            <p style='font-size:15px;'>Dear <strong>" + fullname + "</strong>,</p>" +

                        "            <p style='font-size:15px; line-height:1.6;'>" +
                        "              🎉 Your employee account has been <strong>successfully created</strong> in the EMS portal." +
                        "            </p>" +

                        "            <table width='100%' cellpadding='0' cellspacing='0' style='background:#ecfdf5; border:1px solid #22c55e; border-radius:10px; margin:20px 0;'>" +
                        "              <tr>" +
                        "                <td style='padding:15px;'>" +
                        "                  <p style='margin:6px 0; font-size:14px;'><strong>Employee ID:</strong> <span style='color:#166534; font-weight:bold;'>" + id + "</span></p>" +
                        "                  <p style='margin:6px 0; font-size:14px;'><strong>Name:</strong> " + fullname + "</p>" +
                        "                  <p style='margin:6px 0; font-size:14px;'><strong>Registered Email:</strong> " + email + "</p>" +
                        "                </td>" +
                        "              </tr>" +
                        "            </table>" +

                        "            <p style='font-size:14px; line-height:1.6;'>" +
                        "              🔐 <strong>Security Notice:</strong><br>" +
                        "              • Please keep your login credentials confidential.<br>" +
                        "              • We strongly recommend changing your password after first login.<br>" +
                        "              • Do not share your account details with anyone." +
                        "            </p>" +

                        "            <p style='font-size:14px; line-height:1.6;'>" +
                        "              If you did <strong>not</strong> request this registration, please contact the system administrator immediately." +
                        "            </p>" +

                        "            <!-- BUTTON -->" +
                        "            <p style='text-align:center; margin:30px 0;'>" +
                        "              <a href='http://localhost:8080/EMS/login.html' " +
                        "                 style='display:inline-block; padding:14px 28px; background:linear-gradient(135deg,#22c55e,#16a34a); color:#022c22; text-decoration:none; font-weight:bold; border-radius:30px;'>" +
                        "                🚀 Login to EMS" +
                        "              </a>" +
                        "            </p>" +

                        "            <p style='font-size:14px;'>" +
                        "              Regards,<br>" +
                        "              <strong>EMS Administration Team</strong>" +
                        "            </p>" +

                        "          </td>" +
                        "        </tr>" +

                        "        <!-- FOOTER -->" +
                        "        <tr>" +
                        "          <td style='background:#022c22; padding:15px; text-align:center; color:#9ca3af; font-size:12px;'>" +
                        "            © 2025 Employee Management System | Secure & Confidential" +
                        "          </td>" +
                        "        </tr>" +

                        "      </table>" +

                        "    </td>" +
                        "  </tr>" +
                        "</table>" +

                        "</body>" +
                        "</html>";


        if (success) {
            EmailUtil.sendEmail(email, "Welcome to EMS portal", message);
            resp.sendRedirect("login.html");
        }
    }
}

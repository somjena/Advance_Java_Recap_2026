package Controller;

import EmpServices.EmpServices;
import entity.User;
import jakarta.mail.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.EmailUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    String subject = "Your EMS Login OTP – Do Not Share";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String empid = req.getParameter("empid");
        String password = req.getParameter("password");
        EmpServices es = new EmpServices();
        User user =es.verifyCredentials(empid,password);
        if (user!=null){
            int otp = (int)(Math.random()*9000)+1000;
            HttpSession session = req.getSession();
            session.setAttribute("otp",otp);
            session.setAttribute("empid",user.getId());
            session.setAttribute("empname",user.getFullname());
            String msg =
                    "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "  <meta charset='UTF-8'>" +
                            "</head>" +
                            "<body style='font-family: Arial, sans-serif; background:#f9fafb; padding:20px;'>" +

                            "  <div style='max-width:500px; margin:auto; background:#ffffff; padding:20px; border-radius:8px; box-shadow:0 4px 10px rgba(0,0,0,0.1);'>" +

                            "    <h2 style='color:#16a34a; text-align:center;'>Employee Management System</h2>" +

                            "    <p style='font-size:14px; color:#333;'>Dear <b>" + user.getFullname() + "</b>,</p>" +

                            "    <p style='font-size:14px; color:#333;'>Your One-Time Password (OTP) for secure login is:</p>" +

                            "    <div style='text-align:center; margin:20px 0;'>" +
                            "      <span style='font-size:28px; font-weight:bold; letter-spacing:6px; color:#16a34a; background:#f0fdf4; padding:12px 24px; border-radius:6px; display:inline-block;'>" +
                            otp +
                            "      </span>" +
                            "    </div>" +

                            "    <p style='font-size:14px;'>⏳ This OTP is valid for <b>2 minutes</b>.</p>" +

                            "    <div style='background:#fff7ed; border-left:4px solid #ea580c; padding:12px; margin-top:15px;'>" +
                            "      <p style='margin:0; font-size:13px; color:#7c2d12; font-weight:bold;'>⚠ Security Notice</p>" +
                            "      <ul style='font-size:13px; color:#7c2d12; padding-left:18px;'>" +
                            "        <li>Do <b>NOT</b> share your OTP with anyone.</li>" +
                            "        <li>EMS team will <b>never</b> ask for your OTP.</li>" +
                            "        <li>Sharing OTP may lead to unauthorized access.</li>" +
                            "      </ul>" +
                            "    </div>" +

                            "    <p style='font-size:13px; color:#555; margin-top:15px;'>" +
                            "      If you did not request this login, please ignore this email or contact the administrator immediately." +
                            "    </p>" +

                            "    <hr style='margin:20px 0;'>" +

                            "    <p style='font-size:12px; color:#888; text-align:center;'>" +
                            "      © 2025 Employee Management System<br>" +
                            "      EMS Security Team" +
                            "    </p>" +

                            "  </div>" +
                            "</body>" +
                            "</html>";
            EmailUtil.sendEmail(user.getEmail(),subject,msg);
            resp.sendRedirect("otp.jsp");
        }else {
            resp.getWriter().write("Not Valid");
        }



    }

    }


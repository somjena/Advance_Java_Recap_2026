package Controller;

import EmpServices.EmpServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.EmailUtil;

import java.io.IOException;
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private String Domain = "EMPBBS";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String fullname =  req.getParameter("fullname");
       String email = req.getParameter("email");
       int age = Integer.parseInt(req.getParameter("age")) ;
       String gender =  req.getParameter("gender");
       String address =  req.getParameter("address");
       Double salary =  Double.parseDouble(req.getParameter("salary"));
       String password =  req.getParameter("password");
        EmpServices es = new EmpServices();
        String id = Domain+es.getUniqueid();
        if(es.register(id, fullname,salary,address,age,email,gender,password)){
            String message =
                    "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "<meta charset='UTF-8'>" +
                            "<style>" +
                            "body { margin:0; padding:0; background:#0f172a; font-family: 'Segoe UI', Arial, sans-serif; }" +
                            ".wrapper { padding: 30px 10px; }" +
                            ".card { max-width: 600px; margin:auto; background:#020617; border-radius: 12px; " +
                            "box-shadow: 0 0 25px rgba(34,197,94,0.35); overflow:hidden; }" +

                            ".header { text-align:center; padding: 25px; background: linear-gradient(135deg,#22c55e,#4ade80); }" +
                            ".logo { width: 80px; margin-bottom: 10px; }" +
                            ".header h1 { margin:0; color:#022c22; font-size:24px; letter-spacing:1px; }" +

                            ".content { padding: 30px; color:#e5e7eb; }" +
                            ".content p { font-size:15px; line-height:1.7; }" +

                            ".highlight { color:#4ade80; font-weight:600; }" +

                            ".info-box { background:#020617; border:1px solid #22c55e; border-radius:10px; padding:15px; margin:20px 0; }" +
                            ".info-box p { margin:8px 0; font-size:14px; }" +

                            ".badge { display:inline-block; padding:6px 14px; background:#22c55e; color:#022c22; " +
                            "border-radius:20px; font-weight:bold; letter-spacing:1px; }" +

                            ".btn { display:inline-block; margin-top:25px; padding:14px 26px; " +
                            "background: linear-gradient(135deg,#22c55e,#16a34a); color:#022c22; " +
                            "text-decoration:none; font-weight:bold; border-radius:30px; " +
                            "box-shadow: 0 0 15px rgba(34,197,94,0.8); }" +

                            ".footer { text-align:center; padding:20px; font-size:12px; color:#9ca3af; background:#020617; }" +
                            "</style>" +
                            "</head>" +

                            "<body>" +
                            "<div class='wrapper'>" +
                            "<div class='card'>" +

                            "<div class='header'>" +
                            "<img src='https://cdn.vectorstock.com/i/500p/33/70/modern-ems-logo-design-letter-minimalist-vector-55133370.jpg' class='logo'>" +
                            "<h1>Employee Management System</h1>" +
                            "</div>" +

                            "<div class='content'>" +
                            "<p>Dear " + fullname + ",</p>" +

                            "<p>✨ <strong>Registration Successful!</strong></p>" +

                            "<p>Welcome to the <span class='highlight'>Employee Management System (EMS)</span>. " +
                            "Your account has been created successfully.</p>" +

                            "<div class='info-box'>" +
                            "<p><strong>Employee ID:</strong> <span class='badge'>" + id + "</span></p>" +
                            "<p><strong>Password:</strong> <span class='badge'>" +password  + "</span></p>" +
                            "</div>" +

                            "<p>Better Recommendation to Reset This Password</p>" +

                            "<a href='http://localhost:8080/EMS/login.jsp' class='btn'>🚀 Login to EMS</a>" +

                            "<p style='margin-top:30px;'>If this registration wasn’t made by you, " +
                            "please notify the system administrator immediately.</p>" +

                            "<p>Regards,<br><span class='highlight'>EMS Team</span></p>" +
                            "</div>" +

                            "<div class='footer'>" +
                            "© 2025 EMS • Powered by Neon Tech" +
                            "</div>" +

                            "</div>" +
                            "</div>" +
                            "</body>" +
                            "</html>";

            EmailUtil.sendEmail(email,"Welcome to EMS portal",message);
            resp.sendRedirect("login.html");
        }

    }
}

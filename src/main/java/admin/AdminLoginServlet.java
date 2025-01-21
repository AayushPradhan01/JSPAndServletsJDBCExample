package admin;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet("/login")
public class AdminLoginServlet extends HttpServlet {

    private static final String ADMIN_PASSWORD = "1";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String password = request.getParameter("password");

        if (ADMIN_PASSWORD.equals(password)) {
            try {
                response.sendRedirect("dashboard");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            request.setAttribute("error", "Incorrect password! Please try again.");
            request.getRequestDispatcher("/adminLogin.jsp");
        }
    }

}

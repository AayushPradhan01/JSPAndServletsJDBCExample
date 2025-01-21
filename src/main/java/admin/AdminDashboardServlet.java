package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/dashboard")
public class AdminDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String[]> records = new ArrayList<String[]>();

        Connection con = null;
        PreparedStatement pstmt = null;
        PreparedStatement p1 = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://localhost:1433;databaseName=JSPAndServletsJDBCFirstExample;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(dburl);
            System.out.println("Connection successful.");


            String displayDatabaseQuery = "SELECT u.FirstName, u.LastName, u.Gender, u.DateOfBirth, u.EmailID, c.CarName " +
                    "FROM UserInformation u " +
                    "LEFT JOIN Cars c ON u.CarID = c.CarID";

            pstmt = con.prepareStatement(displayDatabaseQuery);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] record = {
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Gender"),
                        rs.getString("DateOfBirth"),
                        rs.getString("EmailID"),
                        rs.getString("CarName")
                };
                records.add(record);
                System.out.println("Record fetched: " + String.join(", ", record));
            }
            rs.close();
            pstmt.close();
            con.close();
        }

        catch (ClassNotFoundException ce) {
            ce.getMessage();
        }
        catch (SQLException se) {
            se.getMessage();
        }
        request.setAttribute("records", records);
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }

}

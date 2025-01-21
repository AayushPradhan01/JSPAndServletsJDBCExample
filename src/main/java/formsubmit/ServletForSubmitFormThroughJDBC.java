package formsubmit;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class ServletForSubmitFormThroughJDBC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("form").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get input data from the form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String car = request.getParameter("car");


        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://localhost:1433;databaseName=JSPAndServletsJDBCFirstExample;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
            con = DriverManager.getConnection(dburl);

            String get_carID_query = "SELECT CarID FROM Cars WHERE CarName=?";
            pstmt = con.prepareStatement(get_carID_query);
            pstmt.setString(1, car);

            rs = pstmt.executeQuery();
            int car_ID = 0;
            if (rs.next()) {
                car_ID = rs.getInt("CarID");
            }

            String insert_query = "INSERT INTO UserInformation(FirstName, LastName, Gender, DateOfBirth, EmailID, CarID) VALUES(?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(insert_query);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, gender);
            pstmt.setString(4, dob);
            pstmt.setString(5, email);
            if (car_ID > 0) {
                pstmt.setInt(6, car_ID); // Use CarID if valid
            } else {
                pstmt.setNull(6, java.sql.Types.INTEGER); // Set CarID as NULL if not found
            }

            int count = pstmt.executeUpdate();
            if (count > 0) {
                System.out.println("Insert Successful");
            }

        }
        catch (Exception ce) {
            ce.printStackTrace();
        }
        finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Form Submitted Successfully!</h2>");
        out.println("<p><strong>First Name:</strong> " + firstName + "</p>");
        out.println("<p><strong>Last Name:</strong> " + lastName + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Car:</strong> " + car + "</p>");
        out.println("<p><strong>Date of Birth:</strong> " + dob + "</p>");
        out.println("<p><strong>Gender:</strong> " + gender + "</p>");
        out.println("</body></html>");
    }
}

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        String status = request.getParameter("status");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");

            PreparedStatement ps = con.prepareStatement("INSERT INTO attendance(studentId, name, status) VALUES (?, ?, ?)");
            ps.setString(1, studentId);
            ps.setString(2, name);
            ps.setString(3, status);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                out.println("<h3>Attendance recorded for " + name + ".</h3>");
            } else {
                out.println("<h3>Failed to record attendance.</h3>");
            }

            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Attendance Portal</title></head>
<body>
  <form action="AttendanceServlet" method="post">
    Student ID: <input type="text" name="studentId" /><br>
    Name: <input type="text" name="name" /><br>
    Attendance: <select name="status">
        <option value="Present">Present</option>
        <option value="Absent">Absent</option>
    </select><br>
    <input type="submit" value="Submit" />
  </form>
</body>
</html>

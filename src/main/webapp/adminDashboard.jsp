<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
  <title>Admin Dashboard</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css">
  <script>
    function refreshPage() {
      location.reload(); // This will refresh the page
    }
  </script>
</head>
<body>
<h2>Admin Dashboard</h2>
<h3>Records</h3>
<!-- Records table will be dynamically populated -->
<table border="1" cellspacing="0" cellpadding="8">
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Gender</th>
    <th>Date of Birth</th>
    <th>EmailID</th>
    <th>Car</th>
  </tr>
  <c:forEach var="record" items="${records}">
    <tr>
      <td>${record[0]}</td>
      <td>${record[1]}</td>
      <td>${record[2]}</td>
      <td>${record[3]}</td>
      <td>${record[4]}</td>
      <td>${record[5]}</td>
    </tr>
  </c:forEach>
</table>
<button onclick="refreshPage()">Refresh Records</button><br><br>
<button onclick="window.location.href='index.jsp'">Back to Home</button>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
  <title>Admin Login</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h2>Admin Login</h2>
<form action="<%=application.getContextPath()%>/login" method="post">
  <label for="password">Enter Password:</label>
  <input type="password" id="password" name="password" required>
  <button type="submit">Login</button>
</form>
<button onclick="document.getElementById('hint').style.display = 'block'">Hint</button>
<div id="hint" style="display:none">
  <p>Password: 123456789</p>
</div>
<button onclick="window.location.href='index.jsp'">Back to Home</button>
</body>
</html>

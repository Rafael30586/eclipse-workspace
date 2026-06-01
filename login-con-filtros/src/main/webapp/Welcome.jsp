<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <h1>Welcome, ${username} </h1>
  
  <form action="logout" method="post">
    <input type="submit" value="logout">
  
  </form>
  
  <style>
    h1{
      color: #53efb0;
    }
  </style>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1 y HTTP 1.0 , esta línea de código es obligatoria para ambas versiones de HTTP
    
    // response.setHeader("Pragma", "no-cache"); // HTTP 1.0 , esta línea de código es obligatoria solo para la versión 1.0 de HTTP
    
    // response.setHeader("Expires", "0"); // para servidores proxy
    
    String username = (String)session.getAttribute("username");
    if(username == null){
    	response.sendRedirect("login.jsp");
    }
  %>
  <h1>Welcome ${username} </h1>
  
  <a href="videos.jsp">Videos</a>
  
  <form action="/login/logout">
    <input type="submit" value="Logout">
  
  </form>
  
  <style>
    h1{
      color: #12f681;
    }
  </style>

</body>
</html>
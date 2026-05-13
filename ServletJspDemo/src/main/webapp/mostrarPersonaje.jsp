<%@page import="com.rafael.model.Personaje"%>
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
     Personaje p1 = (Personaje)session.getAttribute("personaje");
    
  
    out.println(p1);
  
  %>

  <style>
    body{
      background-color: #7dcb4c;
    }
  
  </style>
</body>
</html>
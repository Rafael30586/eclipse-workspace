<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--
  ${estudiante.nombre} <br>	
  <c:out value="Hola mundo"/>
  -->
  
  <c:forEach items="${pibes}" var="p">
    <h2>${p}</h2>
  </c:forEach>
  
  <style>
  h2{
    color: #30850a;
    }
  
  </style>
</body>
</html>
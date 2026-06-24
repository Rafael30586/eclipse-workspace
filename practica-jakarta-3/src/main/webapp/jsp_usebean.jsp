<%@page import="com.rafael.model.Empleado"%>
<%@page import="com.rafael.model.Persona"%>
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
  Persona p = new Persona("Fernando Rafael", "Alvarez");
  pageContext.setAttribute("persona", p);
  
  Empleado p2 = new Empleado();
  p2.setSalario(4000000);
  p2.setNombres("Carlos Sebastián");
  p2.setApellido("Lopez");
  pageContext.setAttribute("persona2", p2);
%>

<jsp:useBean id="persona" scope="page" class="com.rafael.model.Persona">
</jsp:useBean>

<jsp:useBean id="persona2" scope="page" class="com.rafael.model.Empleado">
</jsp:useBean>

<jsp:getProperty property="nombres" name="persona"/>
<jsp:getProperty property="apellido" name="persona"/>

<br>

<jsp:getProperty property="nombres" name="persona2"/>
<jsp:getProperty property="apellido" name="persona2"/>
<jsp:getProperty property="salario" name="persona2"/>

</body>
</html>
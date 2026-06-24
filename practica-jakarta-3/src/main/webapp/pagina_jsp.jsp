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
  
    System.out.println("Reenviando a la otra página");
  
  %>
  <jsp:forward page="resultado.jsp">
    <jsp:param value="hola" name="saludo"/>
    <jsp:param value="mundo" name="sujeto"/>
  </jsp:forward>
  
  <%
    System.out.println("Solicitud recibida");
  %>
  
 
  </style>

</body>
</html>
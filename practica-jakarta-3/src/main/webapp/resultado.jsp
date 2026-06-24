<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Esta es una página de resultado</h1>
  
  <%
    String saludo = request.getParameter("saludo");
    String sujeto = request.getParameter("sujeto");
    
    System.out.println(saludo+" "+sujeto+"!");
  
  %>
  
  ${param["saludo"]} ${param["sujeto"]}
  <style>
    h1{
      color: #e21c6c;
    }
  
  </style>

</body>
</html>
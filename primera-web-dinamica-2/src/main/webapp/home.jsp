<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	pageContext.setAttribute("nombre", "Rafael", PageContext.SESSION_SCOPE);	
	
	config.getServletContext();	
	int k;
	
	/*
	try{
		k = 9 / 0;
	}catch(Exception e){
		out.println("Ha ocurrido un error");
	}*/
	
	k = 9 / 0;
	%>

</body>
</html>
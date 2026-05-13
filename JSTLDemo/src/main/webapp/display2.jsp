<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%> 
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <sql:setDataSource var="db" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost:5432/rafael" user="postgres" password="rafael"/>
  
  <sql:query var="rs" dataSource="${db}">select * from aparatos</sql:query>
  
  <c:forEach items="${rs.rows}" var="aparato">
    <br> <h2> <c:out value="${aparato.id}"></c:out> : <c:out value="${aparato.nombre}"></c:out> : <c:out value="${aparato.precio}"></c:out> </h2>
  </c:forEach>
  
  <style>
    h2{
      color:#d88414;
    }
  </style>

</body>
</html>
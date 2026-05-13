<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"	%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <c:set var="str" value="Rafael Alvarez es un desarrolador Java"></c:set>
  
  Longitud: ${fn:length(str)} <br>
  
  <c:forEach items="${fn:split(str,' ')}" var="s">
    <span>${fn:indexOf(str,s)}</span> <span class="palabra">${s}</span> <br>
  </c:forEach>
  
  <style>
    .palabra{
      color: #9fff42;
    }
  
  </style>

</body>
</html>
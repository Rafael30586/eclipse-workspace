<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <%
    String url = "jdbc:postgresql://localhost:5432/rafael";
    String username = "postgres";
    String password = "rafael";
    String sql = "select * from personajes where id=2";
    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection(url,username,password);
    Statement st = con.createStatement();
    
    ResultSet rs = st.executeQuery(sql);
    rs.next();
    
  
  %>
  
  Id: <%= rs.getString(1) %> <br>
  Nombre: <%= rs.getString(2) %> <br>
  Apodo: <%= rs.getString(3) %> 

</body>
</html>
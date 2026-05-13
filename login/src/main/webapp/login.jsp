<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <form action="/login/Login" method="post">
    Enter username: <input type="text" name="uname">
    Enter password: <input type="password" name="pass">
    <input type="submit" class="submit-button" value="login">
  </form>
  
  <style>
    form{
      display: flex;
      flex-direction: column;
      background-color:#ad12e4;
      width: 100px;
      color: white;
      padding: 10px;
    }
    
    input{
      margin-top:20px;
      margin-bottom: 20px
    
    }
    
    .submit-button{
      color: #f99a12; 
    }
  
  </style>

</body>
</html>
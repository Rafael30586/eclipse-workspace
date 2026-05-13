<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="addAlien">
    <input type="text" name="aid" class="aid-input"><br>
    <input type="text" name="aname" class="aname-input"><br>
    <input type="submit" class="submit-button">
  </form>
  
  <style>
    form{
      display: flex;
      flex-direction: column;
      background-color: #bf173b;
      width: 100px;
      padding: 20px;
    }
    
    .submit-button{
      color: #2e162a;
    }
  
  </style>

</body>
</html>
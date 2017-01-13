<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Book Store</title>
    </head>
    <body>
        <form method="post" action="${pageContext.servletContext.contextPath}/login">
          Email:<input type="email" name="username">
          Password:<input type="password" name="password">
          <input type="Submit" value="Login">
        </form>
        <a href="${pageContext.servletContext.contextPath}/register">Register</a>      
        ${msg}        
    </body>
</html>

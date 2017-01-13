<%-- 
    Document   : register
    Created on : May 11, 2016, 7:45:45 AM
    Author     : Mac New
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" actiono="${pageContext.servletContext.contextPath}/register" enctype="multipart/form-data">
            First-Name:<input type="text" name="firstname"><br><br>
            Last-Name:<input type="text" name="lastname"><br><br>
            Email:<input type="text" name="username"><br><br>
            Password:<input type="password" name="password"><br><br>
            Gender:<br><br>
            Male:<input type="radio" value="Male" name="gender">Female:<input type="radio" value="female" name="gender"><br><br>
            PhoneNumber:<input type="text" name="phonenumber"><br><br>
            country:<input type="text" name="country"><br><br>
            state:<input type="text" name="state"><br><br>
            city:<input type="text" name="city"><br><br>
            ProfilePicture:<input type="file" name="profilepicture"><br><br>
            <input type="Submit" value="Register">
        </form>
         ${msg}
        
    </body>
</html>

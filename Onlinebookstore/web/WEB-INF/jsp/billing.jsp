<%-- 
    Document   : billing
    Created on : May 13, 2016, 10:15:53 PM
    Author     : Mac New
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Billing Page </h1>
        <c:forEach items="${byinglist}" var="item">
            ${item[0]}
            ${item[1]}
            ${item[2]}
            
            
            
        </c:forEach>
        ${msg}
    </body>
</html>

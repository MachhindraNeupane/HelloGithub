<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Book Store</title>
    </head>
    <body>
             <%
                 if(session.getAttribute("username")==null){
                    response.sendRedirect("index.jsp?msg=you are not autorized user");
                    Date date = new Date();
                    DateFormat df= new SimpleDateFormat("YYYY-MM-dd");
                    String newdate = df.format(date);
                    out.print(newdate);                 }
                    //${username} username display hun6 
                   //<img src="${pageContext.servletContext.contextPath}/resources/images/profilepicture/${profilepicture}"/>
                 %>  
                 ${username}             
                 <center>
                     <form action="${pageContext.servletContext.contextPath}/purchase" method="post">
                 <table>
                     <tr>
                         <th>check box</th>
                         <th>Book Name</th>
                         <th>Writer</th>
                         <th>Quantity</th>
                         <th>Price(Rs)</th>
                     </tr>
                     <c:forEach items="${booklist}" var="item">
                     <tr>
                         <td><input type="checkbox" value="${item.id}" name="bookid"></td>
                         <td>${item.bookname}</td>
                         <td>${item.writername}</td>
                                 <td>
                                     <select name="quantity">
                                         <option value="1">1</option>
                                         <option value="2">2</option>
                                         <option value="3">3</option>
                                         <option value="4">4</option>
                                         <option value="5">5</option>
                                         <option value="6">6</option>
                                    </select>
                                </td>
                        <td>${item.price}</td>         
                     </tr>
                  </c:forEach> 
     </table>
      <input type="submit" value="Purchase">
      </form>
    </center>
                             
    </body>
</html>

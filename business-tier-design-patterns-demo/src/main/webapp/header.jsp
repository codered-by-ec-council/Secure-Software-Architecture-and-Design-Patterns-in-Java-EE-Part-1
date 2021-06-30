<%-- 
    Document   : header
    Created on : Jun 10, 2021, 10:01:00 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Welcome to the Pizza Shop!!!</h1>
        Your site has <%=request.getAttribute("counter")%> visitors  
        <a href="?command=Search&criteria=Vegitarian">Search</a>
        <a href="?command=Logout">Logout</a>
       
    </body>
</html>

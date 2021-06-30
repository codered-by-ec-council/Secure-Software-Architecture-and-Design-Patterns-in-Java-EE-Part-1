<%-- 
    Document   : login
    Created on : Jun 8, 2021, 2:53:14 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
         <form action="?command=Login" method="POST">
            <input type="text" name="username" placeholder="Username">
            </p>
            <input type="password" name="password" placeholder="Password">
            </p>
            <%--<input type="hidden" name="redirect" value="<%= (String) request.getAttribute("redirect") %>">--%>
            <input type="submit" value="Login">
        </form>
    </body>
</html>

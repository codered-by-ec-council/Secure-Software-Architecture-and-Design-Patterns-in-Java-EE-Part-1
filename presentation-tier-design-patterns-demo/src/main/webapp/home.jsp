<%-- 
    Document   : home
    Created on : Jun 8, 2021, 5:07:06 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border=1 valign="top" cellpadding="2%" width="100%">
            <tr>
                <td><jsp:include page="header.jsp" /> </td>
            </tr>
            <tr>
                <td>
                    <jsp:useBean id="collection" class="data.Collection"/>
                    <table border=1 valign="top" width="100%">
                        <c:forEach var="pizza" items="${collection.pizzas}" >
                            <tr>
                                <td>Code: <c:out value="${pizza.code}"/> </td>
                                <td>Name: <c:out value="${pizza.name}"/></td>
                                <td>Category: <c:out value="${pizza.category}"/></td>
                                <td>Size: <c:out value="${pizza.size}"/></td>
                                <td>Topping: <c:out value="${pizza.topping}"/></td>
                                <td>Price: <c:out value="${pizza.price}"/></td>
                                <td><a href="?command=Order&code=${pizza.code}&qty=1">Order</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            <tr>
                <td><%@ include file="footer.html" %> </td>
            </tr>
        </table>
    </body>
</html>

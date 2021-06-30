<%-- 
    Document   : item-found
    Created on : Jun 8, 2021, 4:16:55 PM
    Author     : dell
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="data.Pizza"%>
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
                <td><jsp:include page="header.jsp" /></td>
            </tr>
            <tr>
                <td>
                    <jsp:useBean id="sHelper" class="view.helper.SearchResultsHelper" scope="request"/>
                    <ul>  
                        <c:forEach var="pizza" items="${sHelper.items}" >
                            <li>
                                Code: <c:out value="${pizza.code}"/> </p>
                                Name: <c:out value="${pizza.name}"/></p>
                                Category: <c:out value="${pizza.category}"/></p>
                                Size: <c:out value="${pizza.size}"/></p>
                                Topping: <c:out value="${pizza.topping}"/></p>
                                Price: <c:out value="${pizza.price}"/></p>
                            </li>
                        </c:forEach>
                    </ul>

                    <%--         <% List<Pizza> items = (List)request.getAttribute("items"); %>
                            <ul>
                                <% for (Pizza pizza : items)  { %>
                                    <li>
                                        <%= pizza.getCode() %>  </p>
                                        <%= pizza.getName() %> </p>
                                        <%= pizza.getCategory() %> </p>
                                        <%= pizza.getSize() %> </p>
                                        <%= pizza.getTopping() %> </p>
                                        <%= pizza.getPrice() %> </p>
                                    </li>
                                <% } %>
                            </ul>  --%>
                </td>
            </tr>
            <tr>
                <td><%@ include file="footer.html" %> </td>
            </tr>
        </table>

    </body>
</html>

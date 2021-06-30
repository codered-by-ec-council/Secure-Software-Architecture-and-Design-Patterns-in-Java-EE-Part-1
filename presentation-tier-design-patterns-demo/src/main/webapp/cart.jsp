<%-- 
    Document   : cart
    Created on : Jun 8, 2021, 4:28:53 PM
    Author     : dell
--%>

<%@page import="java.util.Map"%>
<%@page import="data.Pizza"%>
<%@page import="data.Order"%>
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
                    <jsp:useBean id="order" class="data.Order" scope="session"/>

                    <%--  <% Order order = (Order) session.getAttribute("order"); %>
                      <ul>
                          <% for (Map.Entry<Pizza, Integer> entry : order.getItems().entrySet()) { %>
                              <li>
                                  <%= entry.getValue() %>  <%= entry.getKey().getSize() %>
                                  <%= entry.getKey().getName() %> pizza
                                  with <%= entry.getKey().getTopping()%> topping
                              </li>
                          <% } %>
                      </ul> --%>

                    <ul>  
                        <c:forEach var="entry" items="${order.items.entrySet()}" >
                            <li>
                                <c:out value="${entry.value}"/>  <c:out value="${entry.key.size}"/>
                                <c:out value="${entry.key.name}"/> pizza
                                with <c:out value="${entry.key.topping}"/> topping
                            </li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            <tr>
                <td><%@ include file="footer.html" %> </td>
            </tr>
        </table>


    </body>
</html>

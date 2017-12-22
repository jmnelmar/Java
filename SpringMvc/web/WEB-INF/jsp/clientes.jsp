<%-- 
    Document   : clientes
    Created on : Dec 10, 2017, 10:49:39 AM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table >
            <tr>
                <th>id</th>
            <tr>nombre</tr>
            </tr>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.idCliente}"></c:out></td>
                    <td><c:out value="${cliente.nombre}"></c:out></td>

                </tr>
                
            </c:forEach>
        </table>
            
    </body>
</html>

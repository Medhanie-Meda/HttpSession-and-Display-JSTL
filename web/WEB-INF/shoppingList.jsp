<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>
            Hello, ${username} <a href="home?action=logout">Logout</a>
        </p>
        <h1>List</h1>
        <form action="home?action=add" method="post">           
            Add item: <input type="text" name="item"/>
            <input type="submit" value="Add" />
        </form>
        
        
            <form action="home?action=delete" method="post">
                <c:forEach var="item" items="${listItems}" varStatus="status">                    
                    <input type="radio" name="deleteItem" value="${status.index}"> ${item}<br>                    
                </c:forEach>
                
                <c:if test="${listItems != null}">
                    <input type="submit" value="Delete">
                </c:if>
            </form>
            
    </body>
</html>


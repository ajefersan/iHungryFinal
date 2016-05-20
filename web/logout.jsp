<%-- 
    Document   : logout
    Created on : 19/05/2016, 21:16:05
    Author     : jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%  
            session.getLastAccessedTime();
            
            response.sendRedirect("login.html");
        %>
    </body>
</html>

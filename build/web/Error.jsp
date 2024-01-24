<%-- 
    Document   : Error
    Created on : 12 déc. 2023, 10:22:02
    Author     : Mégane Rakotonarivo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="Header.jsp" />
         <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
            <div class="alert alert-danger" role="alert">
                <%= errorMessage %>
            </div>
        <%
            }
        %>
    </body>
</html>

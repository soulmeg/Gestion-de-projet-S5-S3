<%-- 
    Document   : InsertionExperience
    Created on : 24 janv. 2024, 21:48:43
    Author     : Mégane Rakotonarivo
--%>

<%@page import="objet.Grade"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Grade> grades = (Vector<Grade>) request.getAttribute("grades");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <form action="/Baovola/InsertionExperience" method="post">
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;">
            <div class="card" style="width: 20rem;">
               <div class="card-body">
                   <h5 class="card-title" style="text-align: center;">Experience : </h5>  
                    <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="grade">
                        <% for(int i=0;i<grades.size();i++){%>
                        <option value="<%=grades.get(i).getId() %>"><%=grades.get(i).getNom() %></option>
                        <% } %>
                    </select>
                    <input class="form-control form-control-sm mb-3" placeholder="Numéro ou année" name="numero" type="text"  aria-label=".form-control-sm example">
                    <input type="checkbox" name="annee"> Année(s)
                    <input type="checkbox" name="taux"> Taux
                    <div class="d-flex justify-content-center"> 
                       <button type="submit" class="btn btn-primary btn-sm">Enregistrer</button>
                   </div>
               </div>
            </div>
        </div>
        </form>
    </body>
</html>

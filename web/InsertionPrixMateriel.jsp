<%-- 
    Document   : InsertionPrixMateriel
    Created on : 15 janv. 2024, 07:49:46
    Author     : ASUS
--%>

<%@page import="objet.Materiel"%>
<%@page import="objet.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Materiel> materiels = (Vector<Materiel>)request.getAttribute("materiels");
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
        <form action="/Baovola/InsertionPrixMateriel" method="post">
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;">
            <div class="card" style="width: 20rem;">
               <div class="card-body">
                   <h5 class="card-title" style="text-align: center;">Ajouter prix a un materiel</h5>        
                    <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="materiel">
                        <% for(int i=0;i<materiels.size();i++){%>
                        <option value="<%= materiels.get(i).getId_materiel()%>"><%= materiels.get(i).getNom() %></option>
                        <% } %>
                    </select>
                        <input class="form-control form-control-sm mb-3" name="prixMateriel" placeholder="PrixMateriel" type="text"  aria-label=".form-control-sm example"value="100">
                        <input class="form-control form-control-sm mb-3" name="datePrix" type="Date"  aria-label=".form-control-sm example">
                   <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                       <button type="submit" class="btn btn-primary btn-sm">Enregistrer</button>
                   </div>
               </div>
            </div>
        </div>
        </form>
    </body>
</html>
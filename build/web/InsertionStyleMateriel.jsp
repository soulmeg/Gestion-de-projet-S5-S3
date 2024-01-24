<%-- 
    Document   : InsertionStyleMateriel
    Created on : 12 déc. 2023, 15:46:56
    Author     : Mégane Rakotonarivo
--%>
<%@page import="objet.Materiel"%>
<%@page import="objet.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Style> styles = (Vector<Style>)request.getAttribute("styles");
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
        <form action="/Baovola/InsertionSM" method="post">
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;">
            <div class="card" style="width: 20rem;">
               <div class="card-body">
                   <h5 class="card-title" style="text-align: center;">Ajouter un matériel pour un style</h5>        
                    <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="style">
                        <% for(int i=0;i<styles.size();i++){%>
                        <option value="<%= styles.get(i).getId_style()%>"><%= styles.get(i).getNom() %></option>
                        <% } %>
                    </select>
                    <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="materiel">
                        <% for(int i=0;i<materiels.size();i++){%>
                        <option value="<%= materiels.get(i).getId_materiel()%>"><%= materiels.get(i).getNom() %></option>
                        <% } %>
                    </select>
                    <input class="form-control form-control-sm mb-3" name="nomSM" placeholder="NOM" type="text"  aria-label=".form-control-sm example" value="">
                   <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                       <button type="submit" class="btn btn-primary btn-sm">Enregistrer</button>
                   </div>
               </div>
            </div>
        </div>
        </form>
    </body>
</html>
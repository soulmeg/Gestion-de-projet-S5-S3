<%-- 
    Document   : InsertionEmployeFabrication
    Created on : 16 janv. 2024, 14:25:54
    Author     : ASUS
--%>

<%@page import="objet.Meuble"%>
<%@page import="objet.Role"%>
<%@page import="objet.Volume"%>
<%@page import="objet.Categorie"%>
<%@page import="objet.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Meuble> m = (Vector<Meuble>)request.getAttribute("meubles");
    Vector<Volume> volumes = (Vector<Volume>)request.getAttribute("volumes");
    Vector<Role> roles = (Vector<Role>)request.getAttribute("roles");
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
        <form action="/Baovola/InsertionEmployeFabrication" method="post">
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;">
            <div class="card" style="width: 20rem;">
               <div class="card-body">
                   <h5 class="card-title" style="text-align: center;">Nombre d'employe lors d'une fabrication</h5>  
                    <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="meuble">
                        <% for(int i=0;i<m.size();i++){%>
                        <option value="<%= m.get(i).getId() %>"><%= m.get(i).getNom_meuble() %></option>
                        <% } %>
                    </select>
                    <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="volume">
                        <% for(int i=0;i<volumes.size();i++){%>
                        <option value="<%= volumes.get(i).getId_volume()%>"><%= volumes.get(i).getVolume() %></option>
                        <% } %>
                       
                    </select>
                        <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="role">
                        <% for(int i=0;i<roles.size();i++){%>
                        <option value="<%= roles.get(i).getId_role() %>"><%= roles.get(i).getRole()%></option>
                        <% } %>
                       
                    </select>
                    <input class="form-control form-control-sm mb-3" name="nombre" placeholder="Nombre" type="text"  aria-label=".form-control-sm example"value="10"> Nombre d'employé(s)
                   <br>
                   <br>
                    <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                       <button type="submit" class="btn btn-primary btn-sm">Enregistrer</button>
                   </div>
               </div>
            </div>
        </div>
        </form>
    </body>
</html>

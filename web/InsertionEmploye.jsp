<%-- 
    Document   : InsertionEmploye
    Created on : 16 janv. 2024, 14:47:49
    Author     : ASUS
--%>

<%@page import="objet.Personne"%>
<%@page import="objet.Role"%>
<%@page import="objet.Volume"%>
<%@page import="objet.Categorie"%>
<%@page import="objet.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Personne> styles = (Vector<Personne>)request.getAttribute("personnes");
    Vector<Role> roles  = (Vector<Role>) request.getAttribute("roles");
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
        <form action="/Baovola/InsertionEmploye" method="post">
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;">
            <div class="card" style="width: 20rem;">
               <div class="card-body">
                   <h5 class="card-title" style="text-align: center;">Embaucher un employe : </h5>  
                
                    <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="personne">
                        <% for(int i=0;i<styles.size();i++){%>
                        <option value="<%= styles.get(i).getId_personne()%>"><%= styles.get(i).getNom() %> <%= styles.get(i).getPrenom()%></option>
                        <% } %>
                    </select>
                    <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="role">
                        <% for(int i=0;i<roles.size();i++){%>
                        <option value="<%=roles.get(i).getId_role() %>"><%=roles.get(i).getRole() %></option>
                        <% } %>
                    </select>
                     <input class="form-control form-control-sm mb-3" name="dateEmbauche" type="date"  aria-label=".form-control-sm example">
                   <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                       <button type="submit" class="btn btn-primary btn-sm">Enregistrer</button>
                   </div>
               </div>
            </div>
        </div>
        </form>
    </body>
</html>

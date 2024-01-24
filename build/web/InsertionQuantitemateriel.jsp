<%-- 
    Document   : InsertionQuantitemateriel
    Created on : 19 déc. 2023, 16:03:10
    Author     : Mégane Rakotonarivo
--%>


<%@page import="objet.Stylemateriel"%>
<%@page import="objet.Categorie"%>
<%@page import="objet.Volume"%>
<%@page import="objet.Materiel"%>
<%@page import="objet.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Stylemateriel> vsm = (Vector<Stylemateriel>)request.getAttribute("vsm");
    Vector<Volume> volumes = (Vector<Volume>)request.getAttribute("volumes");
    Vector<Categorie> categories = (Vector<Categorie>)request.getAttribute("categories");
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
        <form action="/Baovola/InsertionQuantitemateriel" method="post">
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;">
            <div class="card" style="width: 20rem;">
               <div class="card-body">
                   <h5 class="card-title" style="text-align: center;">Ajouter information pour une meuble</h5>
                  
                    <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="id_categorie">
                        <%
                            for (int i = 0; i < categories.size(); i++) {
                        %><option value="<%= categories.get(i).getId_categorie() %>"><%= categories.get(i).getNom() %></option><%
                                }
                        %>
                    </select>
                 
                    <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="id_sm">
                        <%
                            for (int i = 0; i < vsm.size(); i++) {
                        %><option value="<%= vsm.get(i).getId() %>"><%=vsm.get(i).getNom() %></option><%
                                }
                        %>
                    </select>
                   
                                    
                   <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="id_volume">
                        <%
                            for (int i = 0; i < volumes.size(); i++) {
                        %><option value="<%= volumes.get(i).getId_volume()%>"><%= volumes.get(i).getVolume() %></option><%
                                }
                        %>
                    </select>
                   
                   <input class="form-control form-control-sm mb-3" name="quantite" placeholder="Quantite" type="text"  aria-label=".form-control-sm example"value="5">
                   <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                       <button type="submit" class="btn btn-primary btn-sm">Enregistrer</button>
                   </div>
               </div>
            </div>
        </div>
        </form>
    </body>
</html>
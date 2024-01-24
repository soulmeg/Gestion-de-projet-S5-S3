<%-- 
    Document   : PosteActuel
    Created on : 23 janv. 2024, 15:25:22
    Author     : Mégane Rakotonarivo
--%>
<%@page import="objet.PosteEmploye"%>
<%@page import="java.util.Vector"%>
<%
    Vector<PosteEmploye> postes = (Vector<PosteEmploye>) request.getAttribute("postes");
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
        <form action="/Baovola/PosteActuel" method="get">
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 40vh;">
            <div class="card" style="width: 20rem;">
               <div class="card-body">
                   <h5 class="card-title" style="text-align: center;">Date :</h5>
                   <input class="form-control form-control-sm mb-3" name="dateN" placeholder="Date" type="date"  aria-label=".form-control-sm example" value="">      
                   <div class="d-flex justify-content-center"> 
                       <button type="submit" class="btn btn-primary btn-sm">Rechercher</button>
                   </div>
               </div>
            </div>
        </div>
        </form>
                 
        <table class="table table-striped">
                <thead>
                    <tr>
                      <th scope="col">Employe</th>
                      <th scope="col">Poste</th>
                      <th scope="col">Taux Horaire</th>
                      <th scope="col">Ancienneté(ans)</th>
                    </tr>

                </thead>
                <tbody>
                  <% for(int i = 0;i<postes.size();i++){ %>
                    <tr>
                        <td><%= postes.get(i).getPersonne().getNom() %> <%= postes.get(i).getPersonne().getPrenom() %></td>
                        <td><%= postes.get(i).getPoste() %></td>
                        <td><%= postes.get(i).getTauxHoraire() %></td>
                        <td><%= postes.get(i).getAnciennete() %></td>
                    </tr>
                   <% } %>
                </tbody>
        </table>
    </body>
</html>

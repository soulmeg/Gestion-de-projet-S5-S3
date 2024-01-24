<%-- 
    Document   : PrixMeuble
    Created on : 9 janv. 2024, 12:45:46
    Author     : ASUS
--%>

<%@page import="objet.V_PrixMeuble"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Vector<V_PrixMeuble> qm = (Vector<V_PrixMeuble>) request.getAttribute("qm") ;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <form action="/Baovola/FiltrePrix" method="get">
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 40vh;">
            <div class="card" style="width: 20rem;">
               <div class="card-body">
                   <h5 class="card-title" style="text-align: center;">Rechercher meuble :</h5>
                   <input class="form-control form-control-sm mb-3" name="prixMin" placeholder="Min" type="text"  aria-label=".form-control-sm example" value="10000">
                   <input class="form-control form-control-sm mb-3" name="prixMax" placeholder="Max" type="text" min="0" aria-label=".form-control-sm example" value="50000">
            
                   <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                       <button type="submit" class="btn btn-primary btn-sm">Enregistrer</button>
                   </div>
               </div>
            </div>
        </div>
        </form>
                 
                    <table class="table table-striped">
                            <thead>
                                <tr>
                                  <th scope="col">Catégorie</th>
                                  <th scope="col">Style</th>
                                  <th scope="col">Taille</th>
                                  <th scope="col">Prix</th>
                                </tr>

                            </thead>
                            <tbody>
                              <% for(int i = 0;i<qm.size();i++){ %>
                                <tr>
                                    <td><%= qm.get(i).getNom_categorie() %></td>
                                 <td><%= qm.get(i).getNom_style() %></td>
                                 <td><%= qm.get(i).getVolume() %></td>
                                 <td><%= qm.get(i).getPrix() %></td>
                                </tr>
                               <% } %>
                            </tbody>
                    </table>
    </body>
</html>
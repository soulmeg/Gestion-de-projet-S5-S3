<%-- 
    Document   : Benefice
    Created on : 16 janv. 2024, 16:17:37
    Author     : Mégane Rakotonarivo
--%>

<%@page import="objet.V_Benefice"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Vector<V_Benefice> benefices = (Vector<V_Benefice>) request.getAttribute("benefices") ;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <form action="/Baovola/FiltreBenefice" method="get">
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 40vh;">
            <div class="card" style="width: 20rem;">
               <div class="card-body">
                   <h5 class="card-title" style="text-align: center;">Benefice Meuble :</h5>
                   <input class="form-control form-control-sm mb-3" name="prixMin" placeholder="Min" type="text"  aria-label=".form-control-sm example"value="0">
                   <input class="form-control form-control-sm mb-3" name="prixMax" placeholder="Max" type="text" min="0" aria-label=".form-control-sm example"value="100000">
            
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
                      <th scope="col">Total nombre employes</th>
                      <th scope="col">Benefice</th>
                    </tr>

                </thead>
                <tbody>
                  <% for(int i = 0;i<benefices.size();i++){ %>
                    <tr>
                        <td><%= benefices.get(i).getNom_categorie() %></td>
                     <td><%= benefices.get(i).getNom_style() %></td>
                     <td><%= benefices.get(i).getVolume() %></td>
                     <td><%= benefices.get(i).getNombreEmploye() %></td>
                     <td><%= benefices.get(i).getBenefice() %></td>
                    </tr>
                   <% } %>
                </tbody>
        </table>
</body>
</html>
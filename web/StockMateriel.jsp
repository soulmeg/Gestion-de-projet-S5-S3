<%-- 
    Document   : StockMateriel
    Created on : 16 janv. 2024, 10:45:14
    Author     : Mégane Rakotonarivo
--%>
<%@page import="objet.V_Mouvement"%>
<%@page import="java.util.Vector"%>
<%
    Vector<V_Mouvement> m = (Vector<V_Mouvement>) request.getAttribute("mouvements");
%>
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
        <form action="/Baovola/StockMateriel" method="get">
            <h5 class="card-title" style="text-align: center;"> Stock de Matériel</h5> 
            <input class="form-control form-control-sm mb-3" name="idMateriel" placeholder="Materiel" type="text"  aria-label=".form-control-sm example" value="">
            <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                       <button type="submit" class="btn btn-primary btn-sm">Rechercher</button>
            </div>
        </form> 
                   <br>
                   <br>
                   <br>
                    <table class="table table-striped">
                            <thead>
                                <tr>
                                  <th scope="col">Nom Matériel</th>
                                  <th scope="col">Quantité</th>
                                </tr>

                            </thead>
                            <tbody>
                              <% for(int i = 0;i<m.size();i++){ %>
                                <tr>
                                    <td><%= m.get(i).getNom() %></td>
                                    <td><%= m.get(i).getReste() %></td>
                                </tr>
                               <% } %>
                            </tbody>
                    </table>


    </body>
</html>

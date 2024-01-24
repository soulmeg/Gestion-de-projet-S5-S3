<%-- 
    Document   : ListeMeubleMateriel
    Created on : 19 déc. 2023, 14:53:48
    Author     : Mégane Rakotonarivo
--%>

<%@page import="objet.V_QuantiteMateriel"%>
<%@page import="objet.Materiel"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Materiel> materiels = (Vector<Materiel>)request.getAttribute("materiels");
    Vector<V_QuantiteMateriel> qm = (Vector<V_QuantiteMateriel>) request.getAttribute("qm");
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
        <form action="/Baovola/ListeMeubleMateriel" method="get">
            <h5 class="card-title" style="text-align: center;"> Liste Meuble par Matériel</h5> 
             <select class="form-select form-select-sm mb-3" aria-label="Default select example" name="id_materiel">
                 <% for(int i=0;i<materiels.size();i++){%>
                 <option value="<%= materiels.get(i).getId_materiel() %>"><%= materiels.get(i).getNom() %></option>
                 <% } %>     
             </select>
             <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                       <button type="submit" class="btn btn-primary btn-sm">valider</button>
                   </div>
        </form> 
                   <br>
                   <br>
                   <br>
                    <table class="table table-striped">
                            <thead>
                                <tr>
                                  <th scope="col">Catégorie</th>
                                  <th scope="col">Style</th>
                                  <th scope="col">Taille</th>
                                  <th scope="col">Quantité</th>
                                </tr>

                            </thead>
                            <tbody>
                              <% for(int i = 0;i<qm.size();i++){ %>
                                <tr>
                                    <td><%= qm.get(i).getNom_categorie() %></td>
                                 <td><%= qm.get(i).getNom_style() %></td>
                                 <td><%= qm.get(i).getVolume() %></td>
                                 <td><%= qm.get(i).getQuantite() %></td>
                                </tr>
                               <% } %>
                            </tbody>
                    </table>


    </body>
</html>

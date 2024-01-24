<%-- 
    Document   : ListeStyleMateriel
    Created on : 12 déc. 2023, 15:58:24
    Author     : Mégane Rakotonarivo
--%>
<%@page import="objet.V_stylemateriel"%>
<%@page import="objet.Stylemateriel"%>
<%@page import="objet.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Style> styles = (Vector<Style>)request.getAttribute("styles");
    Vector<V_stylemateriel> sm = (Vector<V_stylemateriel>) request.getAttribute("sm");
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
        <form action="/Baovola/ListeSMServlet" method="get">
            <h5 class="card-title" style="text-align: center;"> Liste Matériel par Style</h5> 
             <select class="form-select form-select-sm mb-3" aria-label="Default select example" name="id_style">
                 <% for(int i=0;i<styles.size();i++){%>
                 <option value="<%= styles.get(i).getId_style()%>"><%= styles.get(i).getNom() %></option>
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
                                  <th scope="col">Materiel</th>
                                </tr>

                            </thead>
                            <tbody>
                                
                                 <% for(int i=0 ;i<sm.size();i++){%>
                                 <tr>
                                 <td><%= sm.get(i).getNom() %></td>
                                 </tr>
                                 <%}%>
                                
                            </tbody>
                    </table>


    </body>
</html>

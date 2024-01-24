<%-- 
    Document   : InsertionFitaovana
    Created on : 12 déc. 2023, 15:41:35
    Author     : Mégane Rakotonarivo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <form action="/Baovola/InsertionCategorie" method="post">
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;">
            <div class="card" style="width: 20rem;">
               <div class="card-body">
                   <h5 class="card-title" style="text-align: center;">Ajouter un Categorie</h5>
                   <input class="form-control form-control-sm mb-3" name="categorie" placeholder="categorie" type="text"  aria-label=".form-control-sm example"value="Chaise">
            
                   <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                       <button type="submit" class="btn btn-primary btn-sm">Enregistrer</button>
                   </div>
               </div>
            </div>
        </div>
    </body>
</html>

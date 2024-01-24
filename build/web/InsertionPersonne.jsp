<%-- 
    Document   : InsertionPersonne
    Created on : 16 janv. 2024, 14:01:46
    Author     : ASUS
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
        <form action="/Baovola/InsertionPersonne" method="post">
            <div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;">
            <div class="card" style="width: 20rem;">
               <div class="card-body">
                   <h5 class="card-title" style="text-align: center;">Ajouter une personne</h5>
                   <input class="form-control form-control-sm mb-3" name="nom" placeholder="Nom" type="text"  aria-label=".form-control-sm example"value="Jean">
                   <input class="form-control form-control-sm mb-3" name="prenom" placeholder="Prenom" type="text"  aria-label=".form-control-sm example"value="Jacque">
                   <input class="form-control form-control-sm mb-3" name="dateNaissance"  type="date"  aria-label=".form-control-sm example">
                   <select class="form-control form-control-sm mb-3" aria-label="Default select example" name="sexe">
                     
                        <option value="Homme">Homme</option>
                        <option value="Femme">Femme</option>
                    </select>
                   <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                       <button type="submit" class="btn btn-primary btn-sm">Enregistrer</button>
                   </div>
               </div>
            </div>
        </div>
    </body>
</html>

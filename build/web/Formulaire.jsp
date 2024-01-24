<%-- 
    Document   : Formulaire
    Created on : 12 déc. 2023, 10:49:23
    Author     : Mégane Rakotonarivo
--%>

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
        <form action="Execute_entree" method="post">
        <div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;">
        <div class="card" style="width: 20rem;">
           <div class="card-body">
               <h5 class="card-title" style="text-align: center;">Ajouter une entrée</h5>
               <select class="form-select form-select-sm mb-3" aria-label="Default select example" name="article">
                   <option value="cuy">cuy</option>
               </select>
               <input class="form-control form-control-sm mb-3" name="qtt" placeholder="Quantité" type="text"  aria-label=".form-control-sm example"value="1">
                <select class="form-select form-select-sm mb-3" aria-label="Default select example" name="unite">
                    <option value="">f</option>
                    <option value="">m</option>
               </select>
                              <input class="form-control form-control-sm mb-3" name="prixUnitaire" placeholder="prixUnitaire" type="text"  aria-label=".form-control-sm example">
               <input class="form-control form-control-sm mb-3" name="date_entree" type="date"  placeholder="date sortie" aria-label=".form-control-sm example"value="2023-10-11">
               <select class="form-select form-select-sm mb-3" name="magasin">
                   <option value="hey">option</option>
               </select>
               <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                   <button type="submit" class="btn btn-primary btn-sm">Enregistrer</button>
               </div>
           </div>
        </div>
        </div>
    </form>
    </body>
</html>

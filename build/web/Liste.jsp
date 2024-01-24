<%-- 
    Document   : Liste
    Created on : 12 déc. 2023, 09:58:45
    Author     : Mégane Rakotonarivo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Validation</title>
         <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <br>
         <table class="table table-striped">
        <thead>
            <tr>
              <th scope="col">ARTICLE</th>
              <th scope="col">QUANTITE</th>
              <th scope="col">DATE SORTIE</th>
              <th scope="col">MAGASIN</th>
              <th scope="col">DATE DE VALIDATION</th>
              <th scope="col"></th>
          
            </tr>
        </thead>
        <tbody>
        <form action="/Stock/Validations_servlet" method="post">         
            <tr>
                <th scope="row">Po</th>
                <td>23</td>
                <td>2023-12-02</td>
                <td>M1</td>
                <td>
                    <input class="form-control form-control-sm mb-2" name="date_validation" type="date"  placeholder="date dalidation" value="2023-10-11">
                </td>
                <td>
                    <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                         <button type="submit" class="btn btn-primary btn-sm">Valider</button>
                    </div>
                </td>
            </tr>
        </form>
        </tbody>
    </table>
    </body>
</html>

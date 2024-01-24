<%-- 
    Document   : Login
    Created on : 12 déc. 2023, 11:22:14
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
        
        <div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;"> 
        <form action="/Baovola/LoginServlet" method="post">
                <div class="card" style="width: 25rem;">
                   <div class="card-body">
                       <h2 class="card-title" style="text-align: center;font-family: cursive;color: cornflowerblue;">Login</h2>
                       <br>
                        <div class="form-floating mb-1">
                            <input type="text" class="form-control"  value="rakoto@gmail.com" id="floatingPassword" name="mail" placeholder="Email">
                            <label for="floatingPassword">Email</label>
                        </div>
                       <br>
                        <div class="form-floating mb-1">
                            <input type="password" class="form-control"  value="finance" id="floatingPassword" name="mdp" placeholder="Password">
                            <label for="floatingPassword">Password</label>
                        </div>
                        <br>
                       <div class="d-flex justify-content-center"> <!-- Centrer le bouton -->
                           <button type="submit" class="btn btn-primary btn">Se connecter</button>
                       </div>
                   </div>
                </div>
        </form>
    </body>
</html>

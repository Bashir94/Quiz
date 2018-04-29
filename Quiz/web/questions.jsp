<%@page import="Model.SousCategorie.SousCategorie"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Ajouter les questions</title>
  <meta charset="utf-8">
 <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Merriweather:300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/coming-soon.min.css" rel="stylesheet">
</head>
<body>
    <%@include file="navbar.jsp" %>

<div class="container">
  <h2>Ajouter les Questions</h2>
  <form class="form-horizontal" method="POST" action="addQuestions">
  <c:forEach var = "i" begin = "1" end = "30">
      
  
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Question N° ${i}</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" required  placeholder="entrez votre question" name="libelle${i}">
        <br>
        <ul>
            <li class="list-group-item">
                réponse vrai?   <input type="radio" name="optradio${i}" value="1" checked>
                <input type="text" class="form-control" required  placeholder="premier choix" name="choix1-${i}">       
            </li>
            <li class="list-group-item">
                réponse vrai?   <input type="radio" name="optradio${i}" value="2" >
                <input type="text" class="form-control" required placeholder="deuxiéme choix" name="choix2-${i}">
        
            </li>
            <li class="list-group-item">
                réponse vrai?   <input type="radio" name="optradio${i}" value="3" >
                <input type="text" class="form-control" required  placeholder="troisiéme choix" name="choix3-${i}">
        
            </li>
        </ul>
      </div>
      
    </div>
      
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
        </div>
      </div>
    </div>
   
  </c:forEach>
       <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Ajouter</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>

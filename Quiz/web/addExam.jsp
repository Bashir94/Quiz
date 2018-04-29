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
  <title>Ajouter examen</title>
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
   
<%
EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
EntityManager em = emf.createEntityManager();    
String req1 ="select m from SousCategorie m";
Query q1 = em.createQuery(req1);
List<SousCategorie> liste;
liste= q1.getResultList();
em.close();
emf.close();
%>
 <c:set var="liste" value="<%=liste%>"/>
  <%@include file="navbar.jsp" %>
<div class="container">
  <h2>Ajouter un Exam</h2>
  <form class="form-horizontal" method="POST"  action="addExam">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">libelle</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" required id="email" placeholder="libelle de l'examen" name="libelle">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Categorie</label>
      <div class="col-sm-10">    
          <select  name="sc" class="form-control">
          <c:forEach items= '${liste}' var='p' >
               <option value="${p.getIdSC()}"> ${p.getIdSC()} - ${p.getLibelle()}</option>             
            </c:forEach>    
         </select>
      </div>
    </div>
       <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Importer votre examen</label>
      <div class="col-sm-10">    
         <input type="file" class="form-control" name="file">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
        </div>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Ajouter</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>

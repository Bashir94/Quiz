<%@page import="Model.Categorie.Categorie"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="Model.SousCategorie.SousCategorie"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="navbar.jsp" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Les examens</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Merriweather:300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/coming-soon.min.css" rel="stylesheet">

  </head>

  <body>

    <div class="overlay"></div>
<c:set var="con" value="<%=session.getAttribute("Session")%>"/>
<c:set var="type" value="<%=session.getAttribute("Session_type")%>"/>
    <div class="masthead">
      <div class="masthead-bg"></div>
      <div class="container h-100">
        <div class="row h-100">
          <div class="col-12 my-auto">
               <div class="masthead-content text-white py-5 py-md-0">
                            <h2 class="mb-3">Choisissez l'examn!</h2>
                </div>
            <c:forEach items= '${exams}' var='e' >
                 <c:choose>
                        <c:when test="${type=='Prof'}">
                            <a href="editExam.jsp?ide=${e.getIdExam()}" style="color:White">  <li>${e.getLibelle()}</li></a>
                        </c:when>
                        <c:otherwise>
                                <a href="passExam?ide=${e.getIdExam()}&idq=1&rep=4&t=30:00" style="color:White">  <li>${e.getLibelle()}</li> </a>
                        </c:otherwise>
                </c:choose>
            </c:forEach>
          </div>
        </div>
      </div>
    </div>

   

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/vide/jquery.vide.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/coming-soon.min.js"></script>

  </body>

</html>
